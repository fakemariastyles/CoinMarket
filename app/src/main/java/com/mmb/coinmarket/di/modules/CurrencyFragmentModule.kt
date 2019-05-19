package com.mmb.coinmarket.di.modules

import com.mmb.coinmarket.domain.executor.UseCaseExecutorObserveThread
import com.mmb.coinmarket.domain.executor.UseCaseExecutorThread
import com.mmb.coinmarket.domain.intractor.GetLatestUseCase
import com.mmb.coinmarket.domain.repository.CoinMarketRepository
import dagger.Provides

class CurrencyFragmentModule {
    @Provides
    fun getLatestUseCase(
        coinMarketRepository: CoinMarketRepository,
        thread: UseCaseExecutorThread,
        observeThread: UseCaseExecutorObserveThread
    ): GetLatestUseCase {
        return GetLatestUseCase(
            thread = thread, observeThread = observeThread
            , coinMarketRepository = coinMarketRepository
        )
    }
}