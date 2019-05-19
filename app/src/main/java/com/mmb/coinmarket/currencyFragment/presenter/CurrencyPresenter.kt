package com.mmb.coinmarket.currencyFragment.presenter

import com.mmb.coinmarket.R
import com.mmb.coinmarket.currencyFragment.contract.CurrencyContract
import com.mmb.coinmarket.domain.intractor.GetLatestUseCase
import com.mmb.coinmarket.domain.repository.CoinMarketRepository
import javax.inject.Inject

class CurrencyPresenter @Inject constructor(
private val getLatestUseCase: GetLatestUseCase
) : CurrencyContract.Presenter {
    lateinit var view: CurrencyContract.View
    override fun onActivityCreated() {
        getLatestUseCase.execute(
            GetLatestUseCase.None(),
            { view.showCurrency(it) },
            { view.showErrorToUser(R.string.bad_request, R.string.error) })
    }
}
