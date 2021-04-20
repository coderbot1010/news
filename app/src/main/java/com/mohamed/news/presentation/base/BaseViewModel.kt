package com.mohamed.news.presentation.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<STATE> : ViewModel()
{
    var state = MutableLiveData<STATE>()

    fun clear()
    {
        super.onCleared()
        state = MutableLiveData()
    }
}