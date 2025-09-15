package com.colodin.mvicompose.services.data

import java.math.BigDecimal

data class SProductFull(
    val id: Int,
    val title: String,
    val description: String,
    val price: BigDecimal,
    val discountPercentage: BigDecimal,
    val rating: BigDecimal,
    val stock: Int,
    val category: String,
    val thumbnail: String,
    val images: List<String>
)