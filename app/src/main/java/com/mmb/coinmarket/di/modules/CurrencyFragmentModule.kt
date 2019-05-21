package com.mmb.coinmarket.di.modules

import com.mmb.coinmarket.currencyFragment.contract.CurrencyContract
import com.mmb.coinmarket.currencyFragment.presenter.CurrencyPresenter
import com.mmb.coinmarket.data.datasource.CoinMarketDataSource
import com.mmb.coinmarket.data.repository.CoinMarketRepositoryImpl
import com.mmb.coinmarket.domain.intractor.GetLatestUseCase
import com.mmb.coinmarket.domain.repository.CoinMarketRepository
import com.mmb.remote.coinmarketservice.CoinMarketServiceApi
import com.mmb.remote.datasource.CoinMarketDataSourceImpl
import dagger.Module
import dagger.Provides

@Module
class CurrencyFragmentModule {
    @Provides
    fun providesUseCaseExecutorThread() = UseCaseExecutorThreadImpl()

    @Provides
    fun providesUseCaseExecutorObserveThread() = UseCaseExecutorObserveThreadImpl()

    @Provides
    fun providesGetLatestUseCase(
        coinMarketRepository: CoinMarketRepository,
        thread: UseCaseExecutorThreadImpl,
        observeThread: UseCaseExecutorObserveThreadImpl
    ): GetLatestUseCase {
        return GetLatestUseCase(
            thread = thread, observeThread = observeThread
            , coinMarketRepository = coinMarketRepository
        )
    }

    @Provides
    fun providesPresenter(getLatestUseCase: GetLatestUseCase): CurrencyContract.Presenter {
        return CurrencyPresenter(getLatestUseCase)
    }

    @Provides
    fun provideCurrencyRepository(coinMarketDataSource: CoinMarketDataSource):CoinMarketRepository{
        return CoinMarketRepositoryImpl(coinMarketDataSource)
    }

    @Provides
    fun provideCoinMarketDataSource(coinMarketServiceApi: CoinMarketServiceApi):CoinMarketDataSource{
        return CoinMarketDataSourceImpl(coinMarketServiceApi)
    }

}