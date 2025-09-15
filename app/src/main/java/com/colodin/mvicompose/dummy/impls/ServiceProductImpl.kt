package com.colodin.mvicompose.dummy.impls

import com.colodin.mvicompose.dummy.DummyService
import com.colodin.mvicompose.dummy.data.DProductModel
import com.colodin.mvicompose.services.ServiceProduct
import com.colodin.mvicompose.services.data.SProductFull
import com.colodin.mvicompose.services.data.SProductShort
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import java.math.BigDecimal

class ServiceProductImpl : ServiceProduct, KoinComponent {

    private val dummyService: DummyService by inject()

    override suspend fun getProducts(): List<SProductShort> {
        return convertDummyToSProductShort(dummyService.getProducts().products)
    }

    override suspend fun getProduct(id: Int): SProductFull {
        return convertDummyToSProductFull(dummyService.getProduct(id))
    }

    private fun convertDummyToSProductShort(item: DProductModel): SProductShort {
        return SProductShort(id = item.id, title = item.title, price = BigDecimal(item.price), rating = BigDecimal(item.rating), thumbnail = item.thumbnail)
    }

    private fun convertDummyToSProductShort(items: List<DProductModel>): List<SProductShort> {
        return items.map { convertDummyToSProductShort(it) }
    }

    private fun convertDummyToSProductFull(item: DProductModel): SProductFull {
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