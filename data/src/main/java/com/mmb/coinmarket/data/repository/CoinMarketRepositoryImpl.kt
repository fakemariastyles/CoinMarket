package com.mmb.coinmarket.data.repository

import com.mmb.coinmarket.data.datasource.CoinMarketDataSource
import com.mmb.coinmarket.data.entity.CurrencyInfoEntity
import com.mmb.coinmarket.data.entity.toCurrencyInfo
import com.mmb.coinmarket.domain.model.CurrencyInfo
import com.mmb.coinmarket.domain.repository.CoinMarketRepository
import io.reactivex.Single
import javax.inject.Inject

class CoinMarketRepositoryImpl @Inject constructor(private val coinMarketDataSource: CoinMarketDataSource) : CoinMarketRepository{
    override fun getLatest() : Single<List<CurrencyInfo>> {
        return coinMarketDataSource.getLatest().map {items->
            items.map {currencyInfoEntity->
                currencyInfoEntity.toCurrencyInfo()
            }

        }
    }

}