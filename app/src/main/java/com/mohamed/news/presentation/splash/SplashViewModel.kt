package com.mohamed.news.presentation.splash

import com.mohamed.news.domain.usecase.CheckFirstUse
import com.mohamed.news.presentation.base.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SplashViewModel constructor(private val checkFirstUse: CheckFirstUse) : BaseViewModel<SplashViewState>()
{
    fun checkFirstUse() = CoroutineScope(Dispatchers.IO).launch {
        checkFirstUse.run().collect { state.postValue(SplashViewState.FirstUseState(it)) }
    }
}