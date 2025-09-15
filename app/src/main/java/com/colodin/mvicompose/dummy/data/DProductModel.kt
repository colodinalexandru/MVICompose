package com.colodin.mvicompose.dummy.data

data class DProductModel(
    val id: Int,
    val title: String,
    val description: String,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val category: String,
    val thumbnail: String,
    val images: List<String>
)