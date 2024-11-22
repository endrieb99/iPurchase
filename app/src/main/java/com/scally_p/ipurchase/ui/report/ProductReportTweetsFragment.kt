package com.scally_p.ipurchase.ui.report

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.scally_p.ipurchase.databinding.FragmentProductReportTweetsBinding
import com.scally_p.ipurchase.model.report.Tweet
import com.scally_p.ipurchase.ui.report.adapter.ProductTweetAdapter
import com.scally_p.ipurchase.utils.Constants


class ProductReportTweetsFragment : Fragment() {

    private var binding: FragmentProductReportTweetsBinding? = null
    private lateinit var tweetsList: List<Tweet>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments.let {
            val tweets = it!!.getString(Constants.General.TWEETS)
            tweetsList = Gson().fromJson(tweets, object : TypeToken<List<Tweet>>() {}.type)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductReportTweetsBinding.inflate(inflater, container, false)

        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        displayData()
    }

    private fun displayData() {

        val adapter = ProductTweetAdapter(tweetsList)
        binding!!.recyclerView.layoutManager = LinearLayoutManager(binding!!.root.context)
        binding!!.recyclerView.adapter = adapter

        binding!!.emptyLayout.isVisible = !tweetsList.isNotEmpty()
    }

    companion object {
        @JvmStatic
        fun newInstance(param: String) = ProductReportTweetsFragment().apply {
            arguments = Bundle().apply {
                putString(Constants.General.TWEETS, param)
            }
        }
    }
}