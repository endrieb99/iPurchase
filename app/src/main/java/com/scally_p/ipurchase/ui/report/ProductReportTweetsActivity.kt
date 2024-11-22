package com.scally_p.ipurchase.ui.report

import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.*
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson
import com.scally_p.ipurchase.R
import com.scally_p.ipurchase.databinding.ActivityProductReportTweetsBinding
import com.scally_p.ipurchase.model.products.Product
import com.scally_p.ipurchase.model.report.IPScoreReport
import com.scally_p.ipurchase.ui.home.ProductsViewModel
import com.scally_p.ipurchase.utils.Constants
import kotlinx.coroutines.launch
import org.json.JSONObject
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinComponent


class ProductReportTweetsActivity : AppCompatActivity(), OnClickListener, KoinComponent {

    private val tag: String = ProductReportTweetsActivity::class.java.name

    private lateinit var binding: ActivityProductReportTweetsBinding

    private val viewModel: ProductsViewModel by inject()
    private var product: Product? = null
    private var ipScoreReport: IPScoreReport? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductReportTweetsBinding.inflate(layoutInflater)
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
        }
    }

    private fun prepareViews() {
        binding.back.setOnClickListener(this)
    }

    private fun displayData() {
        product =
            viewModel.products.find { it.id == intent.getIntExtra(Constants.General.ID, 0) }
        val result = intent.getStringExtra(Constants.General.JSON)
        ipScoreReport = viewModel.getIPScoreReportFromJson(result ?: JSONObject().toString())

        product?.let {

            binding.toolbarTitle.text = it.name

            setupViewPager()
            setupTabLayout()
        }
    }

    private fun setupViewPager() {
        binding.viewPager.apply {
            adapter = TweetsPagerAdapter(this@ProductReportTweetsActivity)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }
    }

    private fun setupTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Positive"
                1 -> "Neutral"
                else -> "Negative"
            }
        }.attach()
    }

    inner class TweetsPagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        override fun getItemCount(): Int = 3

        override fun createFragment(position: Int): Fragment {
            val tweets = when (position) {
                0 -> ipScoreReport?.report?.tweets?.positive
                1 -> ipScoreReport?.report?.tweets?.neutral
                else -> ipScoreReport?.report?.tweets?.negative
            }
            return ProductReportTweetsFragment.newInstance(Gson().toJson(tweets))
        }
    }
}