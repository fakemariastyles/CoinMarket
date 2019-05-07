package com.mmb.remote.datasource

import com.mmb.remote.Injector
import com.mmb.remote.Retrofit
import com.mmb.remote.data.ListingsDto
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class CoinMarketDataSource {
    fun getLatest() {
        println("got here")
        Retrofit.provideCoinMarketServiceWithRetrofit()
            .getLatest()
            .subscribe({
                println("success")
                Injector.provideListingsRepository().getListingsFromDataSource(it)
            }, { error ->
                println(error)
            })
    }
}