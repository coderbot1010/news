package com.mohamed.news.domain.usecase

import android.content.Context
import com.mohamed.news.domain.repository.NewsRepository
import com.mohamed.news.utils.Preferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetNews constructor(private val context: Context, private val repository: NewsRepository)
{
    suspend fun run() = flow {
        val news = repository.getNews()
        if (news != null) emit(news)
        else emit(repository.getNews(Preferences.getCountry(context)))
    }.catch { error ->
        error.printStackTrace()
        throw error
    }.flowOn(Dispatchers.IO)
}