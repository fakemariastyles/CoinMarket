package com.mmb.coinmarket.currencyFragment

import com.mmb.coinmarket.R
import com.mmb.coinmarket.domain.intractor.GetLatestUseCase
import com.mmb.coinmarket.domain.repository.CoinMarketRepository

class CurrencyPresenter(
    private val getLatestUseCase: GetLatestUseCase,
    private val coinMarketRepository: CoinMarketRepository
) : CurrencyContract.Presenter {
    lateinit var view: CurrencyContract.View
    override fun onActivityCreated() {
        getLatestUseCase.execute(
            GetLatestUseCase.None(),
            { view.showCurrency(it) },
            { view.showErrorToUser(R.string.bad_request, R.string.error) })
    }
}
