package com.mohamed.news.domain.usecase

import android.content.Context
import android.util.Log
import com.mohamed.news.domain.repository.NewsRepository
import com.mohamed.news.utils.DateFormatter
import com.mohamed.news.utils.Preferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.*

class GetNews constructor(private val context: Context, private val repository: NewsRepository)
{
    suspend fun run() = flow {
        var news = repository.getNews()
        if (news == null) news = repository.getNews(Preferences.getCountry(context))
        news.forEach { it.date = if (!it.publishDate.isNullOrEmpty()) DateFormatter.parse(it.publishDate!!) else Date() }
        news.sortBy { it.date?.time ?: Date().time }
        news.reverse()
        emit(news)
    }.catch { error ->
        error.printStackTrace()
        throw error
    }.flowOn(Dispatchers.IO)
}