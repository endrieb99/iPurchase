package com.scally_p.ipurchase.model.report

import com.google.gson.annotations.SerializedName

data class IPScoreReport(

    @SerializedName("Report")
    var report: Report? = null,
)