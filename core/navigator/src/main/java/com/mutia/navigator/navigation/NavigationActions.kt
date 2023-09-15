package com.mutia.navigator.navigation

import android.app.Activity
import android.content.Intent
import com.mutia.base.constant.Args
import com.mutia.base.constant.NavKeys
import javax.inject.Inject

class NavigationActions @Inject constructor(){
    private fun internalIntent(activity: Activity, action: String) =
        Intent(action).setPackage(activity.packageName)

    private fun navigate(activity: Activity, intent: Intent) = activity.startActivity(intent)

    private fun navigateWithFinish(activity: Activity, intent: Intent) {
        activity.startActivity(intent)
        activity.finish()
    }

    private fun paramIntent(intent: Intent, keyNav: String, paramOne: Any?, paramTwo: Any?) {
        intent.putExtra(NavKeys.KEY_NAV_MIDDLE, keyNav)
        when(paramOne) {
            is String -> {intent.putExtra(Args.EXTRA_PARAM_STR_ONE, paramOne)}
            is Int -> {intent.putExtra(Args.EXTRA_PARAM_INT_ONE, paramOne)}
            else -> {}
        }
        when(paramTwo) {
            is String -> {intent.putExtra(Args.EXTRA_PARAM_STR_TWO, paramTwo)}
            is Int -> {intent.putExtra(Args.EXTRA_PARAM_INT_TWO, paramTwo)}
            else -> {}
        }
    }

    /** Home Module */
    fun navigateToHomeModule(activity: Activity, keyNav: String, isFinish: Boolean, paramOne: Any?, paramTwo: Any?) =
        internalIntent(activity, "com.mutia.home.navigate")
            .apply { paramIntent(this, keyNav, paramOne, paramTwo) }
            .also {
                if (isFinish) {
                    navigateWithFinish(activity, it)
                } else {
                    navigate(activity, it)
                }
            }
}