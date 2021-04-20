package com.mohamed.news.presentation.base

import com.mohamed.news.R

abstract class HostActivity : AppActivity()
{
    fun addFragment(fragment: BaseFragment)
    {
        fragment.host = this@HostActivity
        val manager = supportFragmentManager.beginTransaction()
        manager.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out, android.R.anim.fade_in, android.R.anim.fade_out)
        manager.replace(R.id.frame, fragment, fragment.javaClass.name)
        manager.addToBackStack(fragment.id.toString())
        manager.commit()
    }

    private fun popFragment() = supportFragmentManager.popBackStackImmediate()

    override fun onBackPressed()
    {
        if (supportFragmentManager.backStackEntryCount > 1) popFragment()
        else finish()
    }
}