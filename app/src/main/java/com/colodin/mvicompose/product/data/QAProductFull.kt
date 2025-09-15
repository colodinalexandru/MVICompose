package com.colodin.mvicompose.product.data

data class QAProductFull(
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val discountPercentage: String,
    val rating: Float,
    val stock: String,
    val category: String,
    val images: List<String>
)