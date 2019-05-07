package com.mmb.remote.datasource

import com.mmb.remote.Retrofit
import com.mmb.remote.data.ListingsDto
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class CoinMarketDataSource {
    fun getLastest():ListingsDto?{
        Retrofit.provideCoinMarketServiceWithRetrofit()
            .getLatest()
            .subscribeOn(Schedulers.io())
            .doOnSuccess {
            }
            .doOnError {error->
                println(error)
            }
        return null

    }
}