package com.mohamed.news.utils

import android.content.Context

object Preferences
{
    private const val PREFERENCES_NAME = "news_app_preferences"

    fun setIsFirstUse(context: Context, isFirstUse: Boolean = false)
    {
        val editor = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE).edit()
        editor.putBoolean("IS_FIRST_USE", isFirstUse)
        editor.apply()
        editor.commit()
    }

    fun isFirstUse(context: Context): Boolean
    {
        val preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        return preferences.getBoolean("IS_FIRST_USE", true)
    }

    fun setCountry(context: Context, country: String)
    {
        val editor = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE).edit()
        editor.putString("COUNTRY", country)
        editor.apply()
        editor.commit()
    }

    fun getCountry(context: Context): String
    {
        val preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        return preferences.getString("COUNTRY", "us") ?: "us"
    }

    fun clear(context: Context)
    {
        val preferences = context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
        val editor = preferences.edit()
        editor.clear()
        editor.apply()
        editor.commit()
    }
}