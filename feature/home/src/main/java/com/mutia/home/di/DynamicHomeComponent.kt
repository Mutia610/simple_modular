package com.mutia.home.di

import android.content.Context
import com.mutia.home.presenter.HomeFragment
import com.mutia.simple_modular.di.DynamicFeatureDependencies
import dagger.BindsInstance
import dagger.Component
import dagger.hilt.android.EntryPointAccessors

@Component(
    dependencies = [DynamicFeatureDependencies::class],
    modules = [DynamicHomeModule::class]
)
interface DynamicFeatureComponent {
    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context,
            dependencies: DynamicFeatureDependencies
        ): DynamicFeatureComponent
    }

    fun inject(homeFragment: HomeFragment)
}

internal fun HomeFragment.inject() {
    DaggerDynamicFeatureComponent.factory().create(
        requireContext(), EntryPointAccessors.fromApplication(
            requireContext(),
            DynamicFeatureDependencies::class.java
        )
    ).inject(this)
}
