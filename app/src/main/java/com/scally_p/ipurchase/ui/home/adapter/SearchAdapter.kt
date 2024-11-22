package com.scally_p.ipurchase.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.LayoutRes
import androidx.constraintlayout.widget.ConstraintLayout
import com.scally_p.ipurchase.R
import com.scally_p.ipurchase.model.products.Product
import com.scally_p.ipurchase.ui.home.ProductsViewModel
import com.scally_p.ipurchase.utils.ImageUtils
import org.koin.java.KoinJavaComponent

class SearchAdapter(
    context: Context,
    @LayoutRes private val layoutResource: Int,
    private val results: List<Product>,
    private var onSearchAdapterViewClick: OnSearchAdapterViewClick
) :
    ArrayAdapter<Product>(
        context,
        layoutResource,
        results
    ),
    Filterable {

    private var mResults: List<Product> = results
    private val moviesViewModel: ProductsViewModel by KoinJavaComponent.inject(ProductsViewModel::class.java)

    override fun getCount(): Int {
        return mResults.size
    }

    override fun getItem(p0: Int): Product {
        return mResults[p0]
    }

    override fun getItemId(p0: Int): Long {
        return mResults[p0].id?.toLong() ?: 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView as ConstraintLayout? ?: LayoutInflater.from(context)
            .inflate(layoutResource, parent, false) as ConstraintLayout

        val product = getItem(position)

        val image = view.findViewById<ImageView>(R.id.image)
        val title = view.findViewById<TextView>(R.id.title)

        title.text = product.name

        ImageUtils.setGlideImage(
            view,
            image,
            product?.images?.first() ?: ""
        )

        view.setOnClickListener {
            onSearchAdapterViewClick.onSearchProductItemClick(product)
        }
        return view
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun publishResults(
                charSequence: CharSequence?,
                filterResults: Filter.FilterResults
            ) {
                mResults =
                    filterResults.values as List<Product>
                notifyDataSetChanged()
            }

            override fun performFiltering(charSequence: CharSequence?): Filter.FilterResults {
                val queryString = charSequence?.toString()?.toLowerCase()

                val filterResults = Filter.FilterResults()
                filterResults.values = if (queryString == null || queryString.isEmpty())
                    results
                else
                    results.filter {
                        it.name?.toLowerCase()?.contains(queryString) == true
                    }

                return filterResults
            }

        }
    }

    interface OnSearchAdapterViewClick {
        fun onSearchProductItemClick(product: Product)
    }
}