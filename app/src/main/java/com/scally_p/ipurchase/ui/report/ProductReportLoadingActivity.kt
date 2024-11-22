package com.scally_p.ipurchase.ui.report

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.chaquo.python.Python
import com.scally_p.ipurchase.R
import com.scally_p.ipurchase.databinding.ActivityProductReportLoadingBinding
import com.scally_p.ipurchase.iPurchaseApp
import com.scally_p.ipurchase.model.products.Product
import com.scally_p.ipurchase.model.report.IPScoreReport
import com.scally_p.ipurchase.ui.home.ProductsViewModel
import com.scally_p.ipurchase.utils.Constants
import com.scally_p.ipurchase.utils.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONObject
import org.koin.android.ext.android.inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


class ProductReportLoadingActivity : AppCompatActivity(), View.OnClickListener {

    private val tag: String = ProductReportLoadingActivity::class.java.name

    private lateinit var binding: ActivityProductReportLoadingBinding

    private val viewModel: ProductsViewModel by inject()
    private var product: Product? = null
    private var ipScoreReport: IPScoreReport? = null
    private var keyphrase: String? = null
    private var query: String? = null
    private var report: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductReportLoadingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            prepareViews()

            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                prepareData()
                loadWebView()


                getSentimentAnalysisReport()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        binding.particleView.resume()
    }

    override fun onPause() {
        super.onPause()
        binding.particleView.pause()
    }

    override fun onBackPressed() {
        if (binding.webViewLayout.content.isVisible) {
            if (binding.webViewLayout.webView.canGoBack()) {
                binding.webViewLayout.webView.goBack()
            } else {
                binding.webViewLayout.content.isVisible = false
            }
        } else {
            super.onBackPressed()
            finish()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.cancelButton -> {
                onBackPressed()
            }
            R.id.viewProduct -> {
                binding.webViewLayout.content.isVisible = true
            }
            R.id.loadingCompleteButton -> {
                if (ipScoreReport?.report == null) onBackPressed() else viewReport()
            }
        }
    }

    private fun prepareViews() {
        binding.cancelButton.setOnClickListener(this)
        binding.viewProduct.setOnClickListener(this)
        binding.loadingCompleteButton.setOnClickListener(this)

        binding.loadingLayout.isVisible = true
        binding.loadingCompleteLayout.isVisible = false
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun loadWebView() {
        binding.webViewLayout.webView.webViewClient = WebViewClient()
        binding.webViewLayout.webView.loadUrl(product?.purchaseLink ?: "")
        binding.webViewLayout.webView.settings.javaScriptEnabled = true
        binding.webViewLayout.webView.settings.setSupportZoom(true)
    }

    private fun prepareData() {
        product =
            viewModel.products.find { it.id == intent.getIntExtra(Constants.General.ID, 0) }
        keyphrase = intent.getStringExtra(Constants.General.KEYPHRASE)
        query = "${product?.identifier ?: ""} ${keyphrase ?: ""}"
        Log.d(tag, "SentimentAnalysis Query: \n$query")
    }

    private suspend fun getSentimentAnalysisReport() {
        repeatOnLifecycle(Lifecycle.State.STARTED) {
            report = withContext(CoroutineScope(Dispatchers.IO).coroutineContext) {
                executeSentimentAnalysisEngineForResult()
            }
            Log.d(tag, "SentimentAnalysis Report: \n$report")

            ipScoreReport = viewModel.getIPScoreReportFromJson(report ?: JSONObject().toString())

            if (binding.webViewLayout.content.isVisible) showCompleteDialog()
            showComplete()
        }
    }

    private suspend fun executeSentimentAnalysisEngineForResult() =
        suspendCoroutine { cont ->

            iPurchaseApp().startPython()

            val python = Python.getInstance()
            val pythonObject = python.getModule("sentiment_analysis")
            val pyObj = pythonObject.callAttr("get_sentiment_analysis_report", 100000, query)

            cont.resume(pyObj.toString())
        }

    private fun showComplete(alert: Boolean = true) {
        if (alert) {
            Utils.playNotificationSound(this@ProductReportLoadingActivity)
            Utils.vibratePhone(this@ProductReportLoadingActivity)
        }

        binding.particleView.pause()
        binding.loadingLayout.isVisible = false
        binding.loadingCompleteLayout.isVisible = true

        if (ipScoreReport?.report == null) {
            binding.loadingComplete.setAnimation("no_report.json")
            binding.loadingComplete.repeatCount = 0
            binding.loadingComplete.playAnimation()
            binding.loadingCompleteMessage.text = resources.getString(R.string.report_not_generated)
            binding.loadingCompleteButton.text = resources.getString(R.string.okay)
        } else {
            binding.loadingComplete.setAnimation("loading_complete.json")
            binding.loadingComplete.repeatCount = 0
            binding.loadingComplete.playAnimation()
            binding.loadingCompleteMessage.text = resources.getString(R.string.report_is_ready_)
            binding.loadingCompleteButton.text = resources.getString(R.string.view_report)
        }
    }

    private fun showCompleteDialog() {
        ReportLoadingCompleteDialog().Builder(this)
            .cancelable(false)
            .messageText(resources.getString(if (ipScoreReport?.report == null) R.string.report_complete else R.string.report_is_ready_))
            .setDialogButtonClickListener(object :
                ReportLoadingCompleteDialog.DialogButtonClickListener {
                override fun onDialogViewButtonClick(dialog: Dialog) {
                    dialog.dismiss()
                    if (ipScoreReport?.report == null) {
                        binding.webViewLayout.content.isVisible = false
                    } else {
                        viewReport()
                    }
                }

                override fun onDialogCloseButtonClick(dialog: Dialog) {
                    dialog.dismiss()
                }
            })
            .build()
    }

    private fun viewReport() {
        val i = Intent(this@ProductReportLoadingActivity, ProductReportActivity::class.java)
        i.putExtra(Constants.General.ID, intent.getIntExtra(Constants.General.ID, 0))
        i.putExtra(Constants.General.JSON, report)
        startActivity(i)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        finish()
    }
}