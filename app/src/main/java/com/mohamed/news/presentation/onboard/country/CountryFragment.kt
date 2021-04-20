package com.mohamed.news.presentation.onboard.country

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.mohamed.news.databinding.FragmentCountryBinding
import com.mohamed.news.presentation.base.BaseFragment
import com.mohamed.news.presentation.onboard.interests.InterestsFragment
import com.mohamed.news.utils.Constants
import org.koin.android.viewmodel.ext.android.viewModel

class CountryFragment : BaseFragment()
{
    private lateinit var binding: FragmentCountryBinding
    private val viewModel: CountriesViewModel by viewModel()
    private lateinit var adapter: CountriesAdapter

    companion object
    {
        fun newInstance(): CountryFragment
        {
            val instance = CountryFragment()
            val bundle = Bundle()
            instance.arguments = bundle
            return instance
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {
        binding = FragmentCountryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?)
    {
        adapter = CountriesAdapter {
            viewModel.setCountry(host, it)
            next()
        }
        binding.countries.setHasFixedSize(false)
        binding.countries.isNestedScrollingEnabled = false
        binding.countries.layoutManager = LinearLayoutManager(host)
        binding.countries.adapter = adapter
        adapter.setData(Constants.countries)
    }

    private fun next() = host.addFragment(InterestsFragment.newInstance())
}