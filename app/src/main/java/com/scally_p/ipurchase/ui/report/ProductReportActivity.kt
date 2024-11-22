package com.scally_p.ipurchase.ui.report

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.google.android.flexbox.*
import com.scally_p.ipurchase.R
import com.scally_p.ipurchase.databinding.ActivityProductReportBinding
import com.scally_p.ipurchase.model.products.Product
import com.scally_p.ipurchase.ui.home.ProductsViewModel
import com.scally_p.ipurchase.ui.report.adapter.ProductFrequentWordAdapter
import com.scally_p.ipurchase.utils.Constants
import com.scally_p.ipurchase.utils.Utils
import kotlinx.coroutines.launch
import org.json.JSONObject
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinComponent


class ProductReportActivity : AppCompatActivity(), OnClickListener, KoinComponent {

    private val tag: String = ProductReportActivity::class.java.name

    private lateinit var binding: ActivityProductReportBinding

    private val viewModel: ProductsViewModel by inject()
    private var product: Product? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launch {
            prepareViews()

            repeatOnLifecycle(Lifecycle.State.RESUMED) { displayData() }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.back -> {
                onBackPressed()
            }
            R.id.viewTweets -> {
                val i =
                    Intent(this, ProductReportTweetsActivity::class.java)
                i.putExtra(Constants.General.ID, intent.getIntExtra(Constants.General.ID, 0))
                i.putExtra(Constants.General.JSON, intent.getStringExtra(Constants.General.JSON))
                startActivity(i)
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
            }
            R.id.buttonAction -> {
                Utils.launchChromeCustomTab(this, product?.purchaseLink ?: "")
            }
        }
    }

    private fun prepareViews() {
        binding.back.setOnClickListener(this)
        binding.viewTweets.setOnClickListener(this)
        binding.buttonAction.setOnClickListener(this)
    }

    private fun displayData() {
        product =
            viewModel.products.find { it.id == intent.getIntExtra(Constants.General.ID, 0) }
        val result = intent.getStringExtra(Constants.General.JSON)
        val ipScoreReport = viewModel.getIPScoreReportFromJson(result ?: JSONObject().toString())

        product?.let { product ->

            binding.toolbarTitle.text = product.name
            binding.ipScore.text =
                String.format("%.1f", ipScoreReport.report?.ipScore?.toFloat() ?: 0.0f)
            binding.ipScoreDescription.text = resources.getString(
                R.string.score_generated_from,
                String.format("%,d", ipScoreReport.report?.apiQueryCount ?: 0)
            )
            binding.purchaseAdvice.text = ipScoreReport.report?.purchaseAdvice
            binding.price.text = "${product.currency} ${String.format("%.2f", product.price)}"

            val layoutManager = FlexboxLayoutManager(this)
            layoutManager.flexDirection = FlexDirection.ROW
            layoutManager.justifyContent = JustifyContent.FLEX_START
            layoutManager.flexWrap = FlexWrap.WRAP
            layoutManager.alignItems = AlignItems.FLEX_START

            val frequentWords = if ((ipScoreReport.report?.ipScore?.toFloat() ?: 0.0f) > 5) {
                ipScoreReport.report?.frequentWords?.positive
            } else if ((ipScoreReport.report?.ipScore?.toFloat() ?: 0.0f) < 5) {
                ipScoreReport.report?.frequentWords?.negative
            } else ipScoreReport.report?.frequentWords?.neutral

            frequentWords?.filterNot { word -> product.name?.contains(word) == true }

            val adapter = ProductFrequentWordAdapter(frequentWords ?: ArrayList())
            binding.recyclerView.layoutManager = layoutManager
            binding.recyclerView.adapter = adapter
            Log.d(tag, "Item Count ${binding.recyclerView.adapter?.itemCount}")
        }
    }
}