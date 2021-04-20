package com.mohamed.news.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.mohamed.news.presentation.loading.LoadingDialog

class Views
{
    class LoadingView(context: Context)
    {
        private val loading: LoadingDialog = LoadingDialog(context)

        fun show()
        {
            if (!loading.isShowing)
            {
                loading.show()
            }
        }

        fun dismiss()
        {
            if (loading.isShowing)
            {
                loading.dismiss()
            }
        }
    }

    object ImageLoader
    {
        fun load(context: Context, imageView: ImageView, imageURl: String)
        {
            glideLoader(context, imageView, GlideUrl(imageURl, LazyHeaders.Builder().build()))
        }

        private fun glideLoader(context: Context, imageView: ImageView, uri: GlideUrl)
        {
            Glide.with(context).load(uri).thumbnail(0.1f).into(imageView)
        }
    }
}