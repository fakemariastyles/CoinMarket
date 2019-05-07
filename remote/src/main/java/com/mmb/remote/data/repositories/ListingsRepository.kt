package com.mmb.remote.data.repositories

import com.mmb.remote.Injector
import com.mmb.remote.data.ListingsDto
import com.mmb.remote.data.model.ListingsEntity
import com.mmb.remote.datasource.CoinMarketDataSource
import com.mmb.remote.toListingsEntity

class ListingsRepository (val coinMarketDataSource: CoinMarketDataSource){
    fun callDataSourceForData(){
        coinMarketDataSource.getLatest()
    }
    fun getListingsFromDataSource(listingsDto: ListingsDto):List<ListingsEntity?>?{
        return listingsDto.items
            ?.map {
             it?.quote?.uSD?.toListingsEntity()
            }
    }
}

fun main(){
    Injector.provideListingsRepository().callDataSourceForData()
}