package com.scally_p.ipurchase.ui.report.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.scally_p.ipurchase.databinding.ItemProductFrequentWordBinding

class ProductFrequentWordAdapter(private var words: List<String>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ItemViewHolder(private val binding: ItemProductFrequentWordBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(word: String) {
            binding.label.text = word
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemProductFrequentWordBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ItemViewHolder) holder.bind(getItem(position))
    }

    override fun getItemCount(): Int {
        return words.size
    }

    private fun getItem(position: Int): String {
        return words.getOrNull(position) ?: ""
    }
}