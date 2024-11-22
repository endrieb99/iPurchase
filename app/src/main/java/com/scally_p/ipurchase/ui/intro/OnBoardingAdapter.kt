package com.scally_p.ipurchase.ui.intro

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.scally_p.ipurchase.model.onboarding.OnBoardingItem
import com.scally_p.ipurchase.databinding.ItemOnBoardingBinding

class OnBoardingAdapter(private var onBoardingItems: ArrayList<OnBoardingItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ItemViewHolder(private var binding: ItemOnBoardingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(onBoardingItem: OnBoardingItem) {
            binding.image.setImageResource(onBoardingItem.image)
            binding.textTitle.text = binding.root.resources.getString(onBoardingItem.title)
            binding.textDescription.text = binding.root.resources.getString(onBoardingItem.description)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemOnBoardingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return onBoardingItems.size
    }

    private fun getItem(position: Int): OnBoardingItem {
        return onBoardingItems[position]
    }
}