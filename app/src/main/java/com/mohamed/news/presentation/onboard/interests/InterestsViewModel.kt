package com.mohamed.news.presentation.onboard.interests

import android.content.Context
import com.mohamed.news.data.model.Interest
import com.mohamed.news.presentation.base.BaseViewModel
import com.mohamed.news.utils.Constants
import com.mohamed.news.utils.Preferences

class InterestsViewModel : BaseViewModel<InterestsViewState>()
{
    private var interests = mutableListOf<Interest>()
    private var selectedInterests = hashMapOf<Int, String>()

    fun getInterests()
    {
        interests = mutableListOf()
        Constants.interests.forEach { interests.add(Interest(interest = it)) }
        state.postValue(InterestsViewState.DataState(interests))
    }

    fun handleSelection(context: Context, interest: Int)
    {
        if (selectedInterests.containsKey(interest)) selectedInterests.remove(interest)
        else selectedInterests[interest] = context.getString(interest)
        refresh()
    }

    private fun refresh()
    {
        interests.forEach { it.selected = selectedInterests.containsKey(it.interest) }
    }

    fun save(context: Context)
    {
        Preferences.setInterests(context, selectedInterests.keys.toMutableList())
        Preferences.setIsFirstUse(context, false)
    }
}