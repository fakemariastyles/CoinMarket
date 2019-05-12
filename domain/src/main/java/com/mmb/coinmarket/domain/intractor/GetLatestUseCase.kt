package com.mmb.coinmarket.domain.intractor

import com.mmb.coinmarket.domain.executor.UseCaseExecutorObserveThread
import com.mmb.coinmarket.domain.executor.UseCaseExecutorThread
import com.mmb.coinmarket.domain.intractor.Base.SingleUseCase
import com.mmb.coinmarket.domain.model.CurrencyInfo
import com.mmb.coinmarket.domain.repository.CoinMarketRepository
import io.reactivex.Single

class GetLatestUseCase(
    private val coinMarketRepository: CoinMarketRepository
    , private val thread: UseCaseExecutorThread
    , private val observeThread: UseCaseExecutorObserveThread
) : SingleUseCase<Nothing, List<CurrencyInfo>>(thread, observeThread) {
    override fun buildSingle(params: Nothing): Single<List<CurrencyInfo>> {
        return coinMarketRepository.getLatest()
    }

}