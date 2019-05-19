package com.mmb.coinmarket

import android.app.Application
import com.mmb.coinmarket.di.ApplicationComponent
import com.mmb.coinmarket.di.DaggerApplicationComponent
import dagger.Component

class CoinMarketApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
        component.inject(this)
    }
    companion object{
        lateinit var component:ApplicationComponent
    }
}