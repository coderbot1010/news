package com.mohamed.news.utils

import android.content.Context
import android.graphics.Color
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import saschpe.android.customtabs.WebViewFallback
import saschpe.android.customtabs.CustomTabsHelper

object ChromeManager
{
    fun openLink(context: Context, URL: String)
    {
        val customTabsIntent = CustomTabsIntent.Builder().addDefaultShareMenuItem().setToolbarColor(Color.parseColor("#a2b9e2")).setShowTitle(true).build()
        CustomTabsHelper.addKeepAliveExtra(context, customTabsIntent.intent)
        CustomTabsHelper.openCustomTab(context, customTabsIntent, Uri.parse(URL), WebViewFallback())
    }
}