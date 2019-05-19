package com.mmb.coinmarket.di.modules

import android.app.Application
import android.content.Context
import com.mmb.remote.coinmarketservice.CoinMarketServiceApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesCoinMarketServiceApi(retrofit: Retrofit): CoinMarketServiceApi {
        return retrofit.create(CoinMarketServiceApi::class.java)
    }

    @Provides
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    fun provideRetrofitInterface(okHttpClient: OkHttpClient): Retrofit {

        return Retrofit.Builder()
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(CoinMarketServiceApi.BASE_URL)
            .build()
    }

    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient()
            .newBuilder()
            .addInterceptor { chain ->
                val request = chain.request()
                val requestBuilder = request.newBuilder()
                    .header("X-CMC_PRO_API_KEY", "88bc0d7c-568a-4feb-8bdd-774597fbb479")

                val newRequest = requestBuilder.build()
                chain.proceed(newRequest)
            }
            .build()
    }
}