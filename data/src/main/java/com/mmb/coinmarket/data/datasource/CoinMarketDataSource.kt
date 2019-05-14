package com.mmb.coinmarket.data.datasource

import com.mmb.coinmarket.data.entity.CurrencyInfoEntity
import io.reactivex.Single

interface CoinMarketDataSource{
    fun getLatest():Single<List<CurrencyInfoEntity>>
}