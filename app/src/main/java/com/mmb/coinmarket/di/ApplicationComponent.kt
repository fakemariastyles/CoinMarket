package com.mmb.coinmarket.di

import com.mmb.coinmarket.modules.NetworkModule
import dagger.Component

@Component (modules = [NetworkModule::class])
interface ApplicationComponent {
    fun inject(app : ApplicationComponent)
}