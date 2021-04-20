package com.mohamed.news.data.api

import com.mohamed.news.BuildConfig
import com.mohamed.news.data.model.News
import retrofit2.http.*

interface NewsAPIs
{
    @GET("top-headlines")
    suspend fun getNews(@Query("apiKey") apiKey: String = BuildConfig.API_KEY, @Query("country") country: String): Response<MutableList<News>>
}