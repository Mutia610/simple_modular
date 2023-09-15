package com.mutia.simple_modular.ui

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import com.mutia.navigator.activity.MainActivity
import com.mutia.simple_modular.BR
import com.mutia.simple_modular.R
import com.mutia.simple_modular.databinding.ActivitySplashBinding
import com.mutia.uicomponents.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@AndroidEntryPoint
class SplashActivity : BaseActivity<ActivitySplashBinding, SplashViewModel>() {
    override val binding: ActivitySplashBinding by lazy { ActivitySplashBinding.inflate(layoutInflater) }
    override val viewModel: SplashViewModel by viewModels()
    override val bindingVariable: Int = BR.vmActSplash


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //
    }

    override fun onInitViews() {
        setContentView(binding.root)

        if (isIntentFromFcm()) {
            processFcmIntent()
        } else {
            Handler(Looper.getMainLooper()).postDelayed({
                MainActivity.startIntent(this)
            }, 2000)
        }
    }

    private fun isIntentFromFcm(): Boolean {
        return intent.hasExtra("title") &&
                intent.hasExtra("body") &&
                intent.hasExtra("channel") &&
                intent.hasExtra("type")
    }

    private fun processFcmIntent() {

    }

}