package com.mohamed.news.presentation.home

import com.mohamed.news.data.model.News

sealed class HomeViewState
{
    class DataState(val news: MutableList<News>) : HomeViewState()
    class ErrorState(val error: Throwable) : HomeViewState()
    object LoadingState : HomeViewState()
}