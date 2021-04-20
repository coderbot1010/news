package com.mohamed.news.presentation.onboard.country

import android.content.Context
import androidx.lifecycle.ViewModel
import com.mohamed.news.utils.Preferences
import java.util.*

class CountriesViewModel : ViewModel()
{
    fun setCountry(context: Context, country: String) = Preferences.setCountry(context, country.split(",")[1].toLowerCase(Locale.ENGLISH))
}