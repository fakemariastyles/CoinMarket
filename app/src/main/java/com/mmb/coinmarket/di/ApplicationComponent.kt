package com.mmb.coinmarket.di

import android.app.Application
import com.mmb.coinmarket.CoinMarketApplication
import com.mmb.coinmarket.di.modules.AppModule
import com.mmb.coinmarket.di.modules.CurrencyFragmentModule
import com.mmb.coinmarket.di.modules.NetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class , CurrencyFragmentModule::class , AppModule::class])
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: CoinMarketApplication)
}