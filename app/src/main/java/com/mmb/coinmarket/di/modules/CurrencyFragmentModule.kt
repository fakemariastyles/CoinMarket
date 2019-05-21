package com.mmb.coinmarket.di.modules

import com.mmb.coinmarket.domain.intractor.GetLatestUseCase
import com.mmb.coinmarket.domain.repository.CoinMarketRepository
import dagger.Module
import dagger.Provides

@Module
class CurrencyFragmentModule {
    @Provides
    fun providesUseCaseExecutorThread() = UseCaseExecutorObserveThreadImpl()

    @Provides
    fun providesUseCaseExecutorObserveThread() = UseCaseExecutorObserveThreadImpl()

    @Provides
    fun providesgetLatestUseCase(
        coinMarketRepository: CoinMarketRepository,
        thread: UseCaseExecutorThreadImpl,
        observeThread: UseCaseExecutorObserveThreadImpl
    ): GetLatestUseCase {
        return GetLatestUseCase(
            thread = thread, observeThread = observeThread
            , coinMarketRepository = coinMarketRepository
        )
    }
}