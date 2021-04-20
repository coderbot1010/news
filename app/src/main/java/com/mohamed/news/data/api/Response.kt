package com.mohamed.news.data.api

import com.google.gson.annotations.SerializedName

data class Response<RESPONSE>
(
        @SerializedName("articles") var articles: RESPONSE?,
        @SerializedName("totalResults") var total: Int,
        @SerializedName("status") var status: String,
)