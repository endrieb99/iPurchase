package com.scally_p.ipurchase.ui.details

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewpager2.widget.ViewPager2
import com.scally_p.ipurchase.R
import com.scally_p.ipurchase.databinding.ActivityProductBinding
import com.scally_p.ipurchase.databinding.ItemProductColorBinding
import com.scally_p.ipurchase.model.products.Product
import com.scally_p.ipurchase.ui.home.ProductsViewModel
import com.scally_p.ipurchase.ui.report.ProductReportLoadingActivity
import com.scally_p.ipurchase.utils.Constants
import com.scally_p.ipurchase.utils.Utils
import io.realm.RealmList
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinComponent

class ProductActivity : AppCompatActivity(), OnClickListener, KoinComponent {

    private val tag: String = ProductActivity::class.java.name

    private lateinit var binding: ActivityProductBinding

    private val viewModel: ProductsViewModel by inject()
    private var product: Product? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductBinding.inflate(layoutInflater)
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

    override fun onDestroy() {
        super.onDestroy()
        lifecycleScope.cancel()
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.back -> {
                onBackPressed()
            }
            R.id.buttonAction -> {
                KeyphraseDialog().Builder(this)
                    .cancelable(true)
                    .keyphrase(Constants.General.KEYPHRASE_DEFAULT)
                    .limit(Constants.General.KEYPHRASE_LIMIT)
                    .setDialogButtonClickListener(object :
                        KeyphraseDialog.DialogButtonClickListener {
                        override fun onDialogNegativeButtonClick(dialog: Dialog) {
                            dialog.dismiss()
                        }

                        override fun onDialogPositiveButtonClick(
                            dialog: Dialog,
                            keyphrase: String
                        ) {
                            dialog.dismiss()

                            Log.d(tag, "Keyphrase: $keyphrase")

                            val intent =
                                Intent(
                                    this@ProductActivity,
                                    ProductReportLoadingActivity::class.java
                                )
                            intent.putExtra(Constants.General.ID, product?.id)
                            intent.putExtra(Constants.General.KEYPHRASE, keyphrase)
                            startActivity(intent)
                            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
                        }
                    })
                    .build()
            }
        }
    }

    private fun prepareViews() {
        binding.back.setOnClickListener(this)
        binding.buttonAction.setOnClickListener(this)

    }

    @SuppressLint("SetTextI18n")
    private fun displayData() {
        product =
            viewModel.products.find { it.id == intent.getIntExtra(Constants.General.ID, 0) }
        product?.let {

            binding.name.text = it.name
            binding.releaseDate.text = binding.root.resources.getString(
                R.string.released_on,
                Utils.formatDate(it.releaseDate!!)
            )
            binding.price.text = "${it.currency} ${String.format("%.2f", it.price)}"
            displayImages(it.images ?: RealmList())
            displayColors(it.colors ?: RealmList())
        }
    }

    private fun displayImages(images: RealmList<String>) {
        val adapter = ProductViewPagerAdapter(images)
        binding.viewPager.adapter = adapter
        binding.viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.dotsIndicator.attachTo(binding.viewPager)
        binding.viewPager.currentItem = 0
    }

    private fun displayColors(colors: RealmList<String>) {
        binding.colorsContainer.removeAllViews()

        colors.forEach { color ->
            val b = ItemProductColorBinding.inflate(layoutInflater, binding.colorsContainer, false)
            b.color.circleColor = Color.parseColor(color)
            b.color.shadowColor = Color.parseColor(color)
            binding.colorsContainer.addView(b.root)
        }
    }
}