package com.mutia.navigator.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.mutia.navigator.BR
import com.mutia.navigator.R
import com.mutia.navigator.databinding.ActivityMainBinding
import com.mutia.navigator.ext.navigateSafe
import com.mutia.navigator.util.NavManager
import com.mutia.uicomponents.base.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    override val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override val viewModel: MainViewModel by viewModels()
    override val bindingVariable: Int = BR.vmActMain

    private var navController: NavController? = null
    private val navManager by lazy { NavManager() }

    private var activeNavigation: Int = 0

    companion object {
        fun startIntent(activity: Activity) {
            val starter = Intent(activity, MainActivity::class.java)
            activity.startActivity(starter)
            activity.finish()
        }
    }

    override fun setupComponent() {
        super.setupComponent()
        binding.bottomNavigation.itemIconTintList = null

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_home -> {
                    activeNavigation = 0
                    navController?.navigate(R.id.homeFragment)
                    invalidateOptionsMenu()
                }
            }
            true
        }
    }

    override fun onInitViews() {
        setContentView(binding.root)

        navManager.setOnNavEvent {
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.f_main_container)
            navHostFragment?.let { host -> navController = host.findNavController() }
            val currentFragment = navHostFragment?.childFragmentManager?.fragments?.get(0)

            currentFragment?.navigateSafe(it)
        }
    }

    override fun setupArguments() {
        navController?.navigate(R.id.homeFragment)
    }
}