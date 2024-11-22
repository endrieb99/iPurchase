package com.scally_p.ipurchase.ui.home.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.scally_p.ipurchase.R
import com.scally_p.ipurchase.databinding.ItemProductGridBinding
import com.scally_p.ipurchase.model.products.Product
import com.scally_p.ipurchase.utils.ImageUtils

class ProductAdapter(private var onAdapterViewClick: OnAdapterViewClick) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val tag: String = ProductAdapter::class.java.name

    private var mProductList = ArrayList<Product>()

    var productList: ArrayList<Product>
        get() {
            return mProductList
        }

        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            mProductList = value
            notifyDataSetChanged()
        }

    inner class ItemViewHolder(private val binding: ItemProductGridBinding) :
        RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        private var product: Product? = null

        fun bind(Product: Product) {
            this.product = Product

            binding.textName.text = product?.name ?: ""

            ImageUtils.setGlideImage(
                binding.root,
                binding.image,
                product?.images?.first() ?: ""
            )

            binding.cardView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            when (p0!!.id) {
                R.id.cardView -> onAdapterViewClick.onProductItemClick(product!!, binding.image)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ItemProductGridBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    private fun getItem(position: Int): Product {
        return productList[position]
    }

    interface OnAdapterViewClick {
        fun onProductItemClick(product: Product, imageView: ImageView)
    }
}