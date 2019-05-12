package com.mmb.remote.datasource

import com.mmb.coinmarket.data.datasource.CoinMarketDataSource
import com.mmb.coinmarket.data.entity.CurrencyInfoEntity
import com.mmb.remote.coinmarketservice.CoinMarketService
import com.mmb.remote.dto.toListCurrencyInfoEntity
import io.reactivex.Single

class CoinMarketDataSourceImpl(private val coinMarketService: CoinMarketService) : CoinMarketDataSource {
    override fun getLatest(): Single<List<CurrencyInfoEntity>> {
        return coinMarketService.getLatest().map {
            it.toListCurrencyInfoEntity()
        }
    }
}