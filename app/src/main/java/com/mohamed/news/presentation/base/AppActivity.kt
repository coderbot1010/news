package com.mohamed.news.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mohamed.news.utils.Views

abstract class AppActivity : AppCompatActivity()
{
    private lateinit var loading: Views.LoadingView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        loading = Views.LoadingView(this@AppActivity)
    }

    override fun onDestroy()
    {
        super.onDestroy()
        dismissLoading()
    }

    open fun showLoading()
    {
        loading.show()
    }

    open fun dismissLoading()
    {
        loading.dismiss()
    }

    open fun showError(error: String)
    {

    }
}