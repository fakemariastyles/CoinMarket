package com.mmb.remote.coinmarketservice

import com.mmb.remote.dto.ListingsDto
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface CoinMarketService{
    @GET("/v1/cryptocurrency/listings/latest")
    fun getLatest():Single<ListingsDto>
    companion object {
        const val BASE_URL = "https://pro-api.coinmarketcap.com"
    }
}

fun main(){
    val httpClient = OkHttpClient()
        .newBuilder()
        .addInterceptor { chain ->
        val request = chain.request()
        val requestBuilder = request.newBuilder()
            .header("X-CMC_PRO_API_KEY","88bc0d7c-568a-4feb-8bdd-774597fbb479")

        val newRequest = requestBuilder.build()
        chain.proceed(newRequest)
    }
    val retrofit = Retrofit.Builder()
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient.build())
        .baseUrl(CoinMarketService.BASE_URL)
        .build()
        .create(CoinMarketService::class.java)
    
    val result = retrofit.getLatest().subscribe({
        println(it)
    },{
        println(it)
    })
}