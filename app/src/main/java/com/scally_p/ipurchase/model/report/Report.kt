package com.scally_p.ipurchase.model.report

import com.google.gson.annotations.SerializedName

data class Report(

    @SerializedName("APIQueryCount")
    var apiQueryCount: Int? = null,

    @SerializedName("IPScore")
    var ipScore: String? = null,

    @SerializedName("PurchaseAdvice")
    var purchaseAdvice: String? = null,

    @SerializedName("FrequentWords")
    var frequentWords: FrequentWords? = null,

    @SerializedName("Tweets")
    var tweets: Tweets? = null
)