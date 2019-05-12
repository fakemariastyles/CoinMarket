package com.mmb.remote.dto

import com.mmb.coinmarket.data.entity.CurrencyInfoEntity
import com.mmb.coinmarket.data.entity.QuoteEntity
import com.mmb.coinmarket.data.entity.UsdEntity

fun ListingsDto.toListCurrencyInfoEntity() = items.map {
    it.toCurrencyInfoEntity()
}
fun CurrencyInfoDto.toCurrencyInfoEntity() = CurrencyInfoEntity(
    name = name ,
    symbol = symbol,
    slug = slug,
    quote = quote.toQuoteEntity()
)
fun QuoteDto.toQuoteEntity() = QuoteEntity(
    uSD = uSD?.toUsdEntity()
)

fun UsdDto.toUsdEntity() = UsdEntity(
    lastUpdated = lastUpdated,
    marketCap =  marketCap,
    percentChange1h = percentChange1h,
    percentChange24h = percentChange24h,
    percentChange7d = percentChange7d,
    price = price,
    volume24h = volume24h
)