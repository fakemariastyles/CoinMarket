package com.mmb.coinmarket.domain.repository

import com.mmb.coinmarket.domain.model.CurrencyInfo
import io.reactivex.Single

interface CoinMarketRepository{
    fun getLatest():Single<List<CurrencyInfo>>
}