package com.mmb.coinmarket.di.modules

import android.content.Context
import com.mmb.coinmarket.CoinMarketApplication
import com.mmb.coinmarket.domain.executor.UseCaseExecutorObserveThread
import com.mmb.coinmarket.domain.executor.UseCaseExecutorThread
import dagger.Module
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton

@Module
class AppModule(val coinMarketApplication: CoinMarketApplication) {

    @Singleton
    fun providesContext(): Context {
        return coinMarketApplication.applicationContext
    }

}

class UseCaseExecutorObserveThreadImpl : UseCaseExecutorObserveThread {
    override var scheduler: Scheduler = AndroidSchedulers.mainThread()
}

class  UseCaseExecutorThreadImpl :  UseCaseExecutorThread {
    override val scheduler: Scheduler = Schedulers.io()
}