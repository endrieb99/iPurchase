package com.scally_p.ipurchase.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.scally_p.ipurchase.databinding.ItemProductViewpagerBinding
import com.scally_p.ipurchase.utils.ImageUtils
import io.realm.RealmList

class ProductViewPagerAdapter(private var images: RealmList<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ItemViewHolder(private val binding: ItemProductViewpagerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(image: String) {
            ImageUtils.setGlideImage(
                binding.root,
                binding.image,
                image
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemProductViewpagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return images.size
    }

    private fun getItem(position: Int): String {
        return images.getOrNull(position) ?: ""
    }
}