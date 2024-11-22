package com.scally_p.ipurchase.model.report

data class FrequentWords(

    var positive: List<String>? = null,
    var negative: List<String>? = null,
    var neutral: List<String>? = null
)