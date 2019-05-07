package com.mmb.remote

import com.mmb.remote.data.USDDto
import com.mmb.remote.data.model.ListingsEntity
import com.mmb.remote.data.repositories.ListingsRepository
import com.mmb.remote.datasource.CoinMarketDataSource

object Injector {
    fun provideListingsRepository() = ListingsRepository(provideCoinMarketDataSource())
    fun provideCoinMarketDataSource() = CoinMarketDataSource()

}
fun USDDto.toListingsEntity() = ListingsEntity(
    lastUpdated = lastUpdated, percentChange1h = percentChange1h
    , percentChange7d = percentChange7d, percentChange24h = percentChange24h, price = price
)