package com.scally_p.ipurchase.ui.report.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.scally_p.ipurchase.databinding.ItemProductReportTweetBinding
import com.scally_p.ipurchase.model.report.Tweet
import com.scally_p.ipurchase.utils.Utils

class ProductTweetAdapter(private var tweets: List<Tweet>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class ItemViewHolder(private val binding: ItemProductReportTweetBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(tweet: Tweet) {
            binding.message.text = tweet.tweet ?: ""
            binding.location.text = tweet.location ?: ""
            binding.date.text = Utils.formatDate(tweet.date ?: "")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding =
            ItemProductReportTweetBinding.inflate(
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
        return tweets.size
    }

    private fun getItem(position: Int): Tweet {
        return tweets[position]
    }
}