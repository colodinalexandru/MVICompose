package com.colodin.mvicompose.services.data

import java.math.BigDecimal

data class SProductShort(
    val id: Int,
    val title: String,
    val price: BigDecimal,
    val rating: BigDecimal,
    val thumbnail: String
)