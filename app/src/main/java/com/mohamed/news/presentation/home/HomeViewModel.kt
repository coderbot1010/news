package com.mohamed.news.presentation.home

import com.mohamed.news.domain.usecase.GetNews
import com.mohamed.news.presentation.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class HomeViewModel constructor(private val getNews: GetNews) : BaseViewModel<HomeViewState>()
{
    fun getNews() = CoroutineScope(Dispatchers.IO).launch {
        getNews.run().catch { error ->
            state.postValue(HomeViewState.ErrorState(error))
        }.collect {
            state.postValue(HomeViewState.DataState(it))
        }
    }
}