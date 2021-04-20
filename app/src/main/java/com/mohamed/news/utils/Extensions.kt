package com.mohamed.news.utils

import android.view.View
import android.widget.TextView

fun TextView.setTextWithVisibilityCheck(text: String?)
{
    this.text = text
    visibility = if (!text.isNullOrEmpty()) View.VISIBLE
    else View.GONE
}