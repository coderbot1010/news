package com.mohamed.news.data.model

import com.google.gson.annotations.SerializedName

data class News(
        @SerializedName("source") var source: Source?,
        @SerializedName("author") var author: String? = "",
        @SerializedName("title") var title: String? = "",
        @SerializedName("description") var description: String? = "",
        @SerializedName("url") var url: String? = "",
        @SerializedName("urlToImage") var image: String? = "",
        @SerializedName("publishedAt") var date: String? = ""
)
{
    data class Source(@SerializedName("id") var id: String? = "", @SerializedName("name") var name: String? = "")
}