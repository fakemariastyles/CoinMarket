package com.mmb.coinmarket.di.modules

import com.mmb.coinmarket.currencyFragment.presenter.CurrencyPresenter
import dagger.Provides

class CurrencyFragmentModule {
    @Provides
    fun provideCurrencyPresenterImpl() {
        return CurrencyPresenter()
    }
}