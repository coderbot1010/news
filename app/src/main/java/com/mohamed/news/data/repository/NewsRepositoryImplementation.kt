package com.mohamed.news.data.repository

import com.mohamed.news.data.api.NewsAPIs
import com.mohamed.news.data.model.News
import com.mohamed.news.domain.repository.NewsRepository
import retrofit2.Retrofit

class NewsRepositoryImplementation constructor(retrofit: Retrofit) : NewsRepository
{
    private val api = retrofit.create(NewsAPIs::class.java)

    private var news: MutableList<News>? = null

    override fun getNews(): MutableList<News>? = news

    override suspend fun getNews(country: String): MutableList<News>
    {
        news = api.getNews(country = country).articles ?: mutableListOf()
        return news!!
    }
}