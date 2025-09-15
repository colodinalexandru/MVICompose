package com.colodin.mvicompose.repositories.product

import com.colodin.mvicompose.services.ServiceProduct
import com.colodin.mvicompose.services.data.SProductFull
import com.colodin.mvicompose.services.data.SProductShort
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RepositoryProductImpl : RepositoryProduct, KoinComponent {

    private val serviceProduct: ServiceProduct by inject()

    /**
     *
     *
     */
    override suspend fun getProducts(): List<SProductShort> {
        return serviceProduct.getProducts()
    }

    /**
     *
     *
     */
    override suspend fun getProduct(id: Int): SProductFull {
        return serviceProduct.getProduct(id)
    }
}