package com.mohamed.news.presentation.onboard.interests

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohamed.news.databinding.FragmentInterestsBinding
import com.mohamed.news.presentation.base.BaseFragment
import com.mohamed.news.presentation.home.HomeActivity
import org.koin.android.viewmodel.ext.android.viewModel

class InterestsFragment : BaseFragment()
{
    private lateinit var binding: FragmentInterestsBinding
    private val viewModel: InterestsViewModel by viewModel()
    private lateinit var adapter: InterestsAdapter

    companion object
    {
        fun newInstance(): InterestsFragment
        {
            val instance = InterestsFragment()
            val bundle = Bundle()
            instance.arguments = bundle
            return instance
        }
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        viewModel.state.observe(this@InterestsFragment, { state -> setView(state) })
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        binding = FragmentInterestsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        binding.done.setOnClickListener {
            viewModel.save(host)
            next()
        }

        adapter = InterestsAdapter { viewModel.handleSelection(host, it.interest) }
        binding.interests.setHasFixedSize(false)
        binding.interests.isNestedScrollingEnabled = false
        binding.interests.layoutManager = LinearLayoutManager(host)
        binding.interests.adapter = adapter
        adapter.setData(mutableListOf())

        viewModel.getInterests()
    }

    private fun setView(state: InterestsViewState)
    {
        when (state)
        {
            is InterestsViewState.DataState -> adapter.setData(state.interests)
        }
    }

    private fun next()
    {
        host.startActivity(Intent(host, HomeActivity::class.java))
        host.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        host.finish()
    }
}