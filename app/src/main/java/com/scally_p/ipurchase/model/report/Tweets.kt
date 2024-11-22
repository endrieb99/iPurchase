package com.scally_p.ipurchase.model.report

data class Tweets(

    var positive: List<Tweet>? = null,
    var negative: List<Tweet>? = null,
    var neutral: List<Tweet>? = null

)