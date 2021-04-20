package com.mohamed.news.presentation.splash

sealed class SplashViewState
{
    class FirstUseState(val isFirstUse: Boolean) : SplashViewState()
}