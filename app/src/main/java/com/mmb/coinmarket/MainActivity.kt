package com.mmb.coinmarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mmb.coinmarket.data.repository.CoinMarketRepositoryImpl
import com.mmb.coinmarket.domain.repository.CoinMarketRepository
import com.mmb.remote.coinmarketservice.CoinMarketServiceApi
import com.mmb.remote.datasource.CoinMarketDataSourceImpl

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val coinMarketRepository = CoinMarketRepositoryImpl(CoinMarketDataSourceImpl())
    }
}
