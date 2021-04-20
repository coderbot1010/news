package com.mohamed.news.domain.usecase

import android.content.Context
import com.mohamed.news.utils.Preferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class CheckFirstUse constructor(private val context: Context)
{
    fun run() = flow {
        emit(Preferences.isFirstUse(context))
    }.catch { error ->
        error.printStackTrace()
        emit(true)
    }.flowOn(Dispatchers.IO)
}