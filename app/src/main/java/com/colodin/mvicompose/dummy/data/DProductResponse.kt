package com.colodin.mvicompose.dummy.data

data class DProductResponse(
    val total: Int,
    val skip: Int,
    val limit: Int,
    val products: List<DProductModel>
)