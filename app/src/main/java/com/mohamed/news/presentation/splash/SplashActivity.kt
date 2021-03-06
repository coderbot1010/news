package com.mohamed.news.presentation.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.mohamed.news.R
import com.mohamed.news.presentation.home.HomeActivity
import com.mohamed.news.presentation.onboard.OnBoardActivity
import com.mohamed.news.utils.Preferences
import org.koin.android.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity()
{
    private val viewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        viewModel.state.observe(this@SplashActivity, { state -> setView(state) })
        Preferences.getInterests(this)

        Handler(Looper.getMainLooper()).postDelayed({ viewModel.checkFirstUse() }, 3000)
    }

    private fun setView(state: SplashViewState)
    {
        when (state)
        {
            is SplashViewState.FirstUseState -> if (state.isFirstUse) openOnBoarding() else openHome()
        }
    }

    private fun openOnBoarding()
    {
        startActivity(Intent(this@SplashActivity, OnBoardActivity::class.java))
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }

    private fun openHome()
    {
        startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        finish()
    }
}