package com.mmb.remote.coinmarketservice

import com.mmb.remote.dto.ListingsDto
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import javax.inject.Inject

interface CoinMarketServiceApi{
    @GET("/v1/cryptocurrency/listings/latest")
    fun getLatest(): Single<ListingsDto>

    companion object {
        const val BASE_URL = "https://pro-api.coinmarketcap.com"
    }
}
