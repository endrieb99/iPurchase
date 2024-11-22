package com.scally_p.ipurchase.model.report

import com.google.gson.annotations.SerializedName

data class Tweet(

    @SerializedName("Date")
    var date: String? = null,

    @SerializedName("ID")
    var id: Long? = null,

    @SerializedName("Link")
    var link: String? = null,

    @SerializedName("Location")
    var location: String? = null,

    @SerializedName("Tweets")
    var tweet: String? = null,

    @SerializedName("polarity")
    var polarity: Float? = null,

    @SerializedName("sentiment")
    var sentiment: String? = null

)