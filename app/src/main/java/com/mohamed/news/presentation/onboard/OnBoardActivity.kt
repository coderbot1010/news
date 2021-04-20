package com.mohamed.news.presentation.onboard

import android.os.Bundle
import com.mohamed.news.R
import com.mohamed.news.presentation.base.HostActivity
import com.mohamed.news.presentation.onboard.country.CountryFragment

class OnBoardActivity : HostActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard)
        addFragment(CountryFragment.newInstance())
    }
}