package com.mmb.coinmarket.data.entity

data class CurrencyInfoEntity(
    val name: String,
    val symbol: String,
    val slug: String,
    val quote: QuoteEntity
)