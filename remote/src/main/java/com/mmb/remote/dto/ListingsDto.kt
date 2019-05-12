package com.mmb.remote.dto

import com.google.gson.annotations.SerializedName

data class ListingsDto(
    @SerializedName("data") val items: List<CurrencyInfoDto>,
    @SerializedName("status") val status: StatusDto
)