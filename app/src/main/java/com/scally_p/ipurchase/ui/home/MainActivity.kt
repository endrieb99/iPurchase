package com.scally_p.ipurchase.ui.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.SimpleItemAnimator
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
import com.scally_p.ipurchase.R
import com.scally_p.ipurchase.databinding.ActivityMainBinding
import com.scally_p.ipurchase.model.products.Product
import com.scally_p.ipurchase.ui.details.ProductActivity
import com.scally_p.ipurchase.ui.home.adapter.ProductAdapter
import com.scally_p.ipurchase.ui.home.adapter.SearchAdapter
import com.scally_p.ipurchase.utils.Constants
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinComponent
import kotlin.math.abs

class MainActivity : AppCompatActivity(), OnClickListener, OnRefreshListener,
    ProductAdapter.OnAdapterViewClick, SearchAdapter.OnSearchAdapterViewClick, KoinComponent {

    private val tag: String = MainActivity::class.java.name

    private lateinit var inputMethodManager: InputMethodManager

    private lateinit var binding: ActivityMainBinding

    private val viewModel: ProductsViewModel by inject()

    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager

        lifecycleScope.launch {
            prepareViews()

            repeatOnLifecycle(Lifecycle.State.RESUMED) { displayData() }
        }
    }

    override fun onPause() {
        binding.content.shimmerFrameLayout.isVisible = false
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        lifecycleScope.cancel()
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.search -> {
                showSearchView()
            }
            R.id.clear -> {
                hideSearchView()
            }
        }
    }

    override fun onRefresh() {

    }

    override fun onProductItemClick(product: Product, imageView: ImageView) {
        hideSearchView()

        val intent = Intent(this, ProductActivity::class.java)
        intent.putExtra(Constants.General.ID, product.id)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    override fun onSearchProductItemClick(product: Product) {
        hideSearchView()

        val intent = Intent(this, ProductActivity::class.java)
        intent.putExtra(Constants.General.ID, product.id)
        startActivity(intent)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
    }

    private fun prepareViews() {
        binding.search.setOnClickListener(this)
        binding.clear.setOnClickListener(this)
        binding.content.swipeRefreshLayout.setOnRefreshListener(this)

        productAdapter = ProductAdapter(this)

        binding.appBarLayout.addOnOffsetChangedListener { appBarLayout, verticalOffset ->
            if (abs(verticalOffset) == appBarLayout.totalScrollRange) {
                binding.titleCollapsed.isVisible = true
                binding.titleExpanded.isVisible = false
            } else {
                binding.titleCollapsed.isVisible = false
                binding.titleExpanded.isVisible = true
            }
        }

        binding.content.recyclerView.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = productAdapter
        }

        (binding.content.recyclerView.itemAnimator as SimpleItemAnimator).supportsChangeAnimations =
            false

        binding.searchTxt.threshold = 1
    }

    private fun displayData() {
        binding.content.shimmerFrameLayout.stopShimmer()
        binding.content.shimmerFrameLayout.isVisible = false

        productAdapter.productList = viewModel.products
        binding.searchTxt.setAdapter(
            SearchAdapter(
                this,
                R.layout.item_product_search,
                viewModel.products,
                this
            )
        )
    }

    private fun showSearchView() {
        inputMethodManager.toggleSoftInput(
            InputMethodManager.SHOW_FORCED,
            InputMethodManager.HIDE_IMPLICIT_ONLY
        )
        binding.searchTxt.requestFocus()

        binding.searchLayout.isVisible = true
        binding.search.isVisible = false
    }

    private fun hideSearchView() {
        inputMethodManager.hideSoftInputFromWindow(binding.searchTxt.windowToken, 0)
        binding.searchTxt.setText("")
        binding.searchTxt.clearFocus()

        binding.searchLayout.isVisible = false
        binding.search.isVisible = true
    }
}