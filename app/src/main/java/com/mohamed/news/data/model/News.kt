package com.mohamed.news.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

data class News(
        @SerializedName("source") var source: Source?,
        @SerializedName("author") var author: String? = "",
        @SerializedName("title") var title: String? = "",
        @SerializedName("description") var description: String? = "",
        @SerializedName("url") var url: String? = "",
        @SerializedName("urlToImage") var image: String? = "",
        @SerializedName("publishedAt") var publishDate: String? = "",
        @Expose(serialize = false, deserialize = false) var date: Date?
)
{
    data class Source(@SerializedName("id") var id: String? = "", @SerializedName("name") var name: String? = "")
}