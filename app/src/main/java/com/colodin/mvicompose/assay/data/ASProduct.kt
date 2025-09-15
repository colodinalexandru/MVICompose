package com.colodin.mvicompose.assay.data

import com.parse.ParseClassName
import com.parse.ParseObject
import java.util.*

@ParseClassName("product")
class ASProduct : ParseObject() {
    val id: Int
        get() = getInt("id")

    val title: String
        get() = getString("title")!!

    val description: String
        get() = getString("description")!!

    val price: Double
        get() = getDouble("price")

    val discountPercentage: Double
        get() = getDouble("discountPercentage")

    val rating: Double
        get() = getDouble("rating")

    val stock: Int
        get() = getInt("stock")

    val category: String
        get() = getString("category")!!

    val thumbnail: String
        get() = getString("thumbnail")!!

    val images: List<String>
        get() = getList("images")!!

}