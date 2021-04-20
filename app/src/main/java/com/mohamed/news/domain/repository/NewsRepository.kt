package com.mohamed.news.domain.repository

import com.mohamed.news.data.model.News

interface NewsRepository
{
    fun getNews(): MutableList<News>?

    suspend fun getNews(country: String): MutableList<News>
}