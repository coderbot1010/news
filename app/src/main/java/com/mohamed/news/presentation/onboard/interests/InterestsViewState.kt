package com.mohamed.news.presentation.onboard.interests

import com.mohamed.news.data.model.Interest

sealed class InterestsViewState
{
    class DataState(val interests: MutableList<Interest>): InterestsViewState()
}