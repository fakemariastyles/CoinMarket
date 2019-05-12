package com.mmb.coinmarket.CurrencyFragment

import com.mmb.coinmarket.domain.model.CurrencyInfo

interface CurrencyContract{
    interface Presenter : CurrencyContract{
        fun onActivityCreated()
    }
    interface View : CurrencyContract{
        fun showCurrency(items: List<CurrencyInfo>)
        fun showErrorToUser(msg : Int , title : Int)
    }
}