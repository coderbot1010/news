package com.mohamed.news.presentation.home

import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.mohamed.news.R
import com.mohamed.news.data.model.News
import com.mohamed.news.databinding.ActivityHomeBinding
import com.mohamed.news.presentation.base.AppActivity
import com.mohamed.news.utils.ChromeManager
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppActivity()
{
    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModel()
    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.state.observe(this@HomeActivity, { state -> setView(state) })

        init()
    }

    override fun onResume()
    {
        super.onResume()
        setView(HomeViewState.LoadingState)
        viewModel.getNews()
    }

    private fun init()
    {
        adapter = NewsAdapter(this@HomeActivity) { if (!it.url.isNullOrEmpty()) ChromeManager.openLink(this@HomeActivity, it.url!!) }
        binding.news.setHasFixedSize(false)
        binding.news.isNestedScrollingEnabled = false
        binding.news.layoutManager = LinearLayoutManager(this@HomeActivity)
        binding.news.adapter = adapter
        adapter.setData(mutableListOf())
    }

    private fun setView(state: HomeViewState)
    {
        when (state)
        {
            is HomeViewState.LoadingState -> showLoading()
            is HomeViewState.DataState -> setData(state.news)
            is HomeViewState.ErrorState -> showError(state.error.message ?: getString(R.string.general_error))
        }
    }

    private fun setData(news: MutableList<News>)
    {
        dismissLoading()
        adapter.setData(news)
    }

    override fun showError(error: String)
    {
        dismissLoading()
        Snackbar.make(binding.mainView, error, Snackbar.LENGTH_LONG).setAction(getString(R.string.ok)) { }.show()
    }
}