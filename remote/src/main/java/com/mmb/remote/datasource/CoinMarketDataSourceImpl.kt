package com.mmb.remote.datasource

import com.mmb.coinmarket.data.datasource.CoinMarketDataSource
import com.mmb.coinmarket.data.entity.CurrencyInfoEntity
import com.mmb.remote.coinmarketservice.CoinMarketServiceApi
import com.mmb.remote.dto.toListCurrencyInfoEntity
import io.reactivex.Single
import javax.inject.Inject

class CoinMarketDataSourceImpl @Inject constructor(val coinMarketServiceApi: CoinMarketServiceApi) : CoinMarketDataSource {
    override fun getLatest(): Single<List<CurrencyInfoEntity>> {
        return coinMarketServiceApi.getLatest().map {
            it.toListCurrencyInfoEntity()
        }
    }
}