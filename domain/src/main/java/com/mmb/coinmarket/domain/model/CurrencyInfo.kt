package com.mmb.coinmarket.domain.model

data class CurrencyInfo(
    val name: String,
    val symbol: String,
    val slug: String,
    val quote: Quote
)