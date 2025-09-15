package com.colodin.mvicompose.assay.impls

import com.colodin.mvicompose.assay.data.ASProduct
import com.colodin.mvicompose.services.ServiceProduct
import com.colodin.mvicompose.services.data.SProductFull
import com.colodin.mvicompose.services.data.SProductShort
import com.parse.ParseQuery
import com.parse.ktx.findAll
import org.koin.core.component.KoinComponent
import java.math.BigDecimal

class AssayServiceProductImpl : ServiceProduct, KoinComponent {

    override suspend fun getProducts(): List<SProductShort> {

        val productsQuery: ParseQuery<ASProduct> = ParseQuery.getQuery(ASProduct::class.java)
        return convertASProductToProductShort(productsQuery.findAll())
    }

    override suspend fun getProduct(id: Int): SProductFull {
        val productQuery: ParseQuery<ASProduct> = ParseQuery.getQuery(ASProduct::class.java)
        productQuery.whereEqualTo("id", id)
        val result = productQuery.find()
        return convertASProductToProductFull(result.first())
    }

    private fun convertASProductToProductShort(item: ASProduct): SProductShort {
        return SProductShort(id = item.id, title = item.title, price = BigDecimal(item.price), rating = BigDecimal(item.rating), thumbnail = item.thumbnail)
    }

    private fun convertASProductToProductShort(items: List<ASProduct>): List<SProductShort> {
        return items.map { convertASProductToProductShort(it) }
    }

    private fun convertASProductToProductFull(item: ASProduct): SProductFull {
        return SProductFull(
            id = item.id,
            title = item.title,
            description = item.description,
            price = BigDecimal(item.price),
            discountPercentage = BigDecimal(item.discountPercentage),
            rating = BigDecimal(item.rating),
            stock = item.stock,
            category = item.category,
            thumbnail = item.thumbnail,
            images = item.images
        )
    }
}