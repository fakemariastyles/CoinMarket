package com.mmb.remote

import com.mmb.remote.coinmarketservice.CoinMarketService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Retrofit {
    fun provideCoinMarketServiceWithRetrofit(): CoinMarketService {
        val httpClient = OkHttpClient()
            .newBuilder()
            .addInterceptor { chain ->
                val request = chain.request()
                val requestBuilder = request.newBuilder()
                    .header("X-CMC_PRO_API_KEY", "88bc0d7c-568a-4feb-8bdd-774597fbb479")

                val newRequest = requestBuilder.build()
                chain.proceed(newRequest)
            }
        return Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .baseUrl(CoinMarketService.BASE_URL)
            .build()
            .create(CoinMarketService::class.java)
    }
}