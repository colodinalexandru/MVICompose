package com.colodin.mvicompose.product.domain

import com.colodin.mvicompose.repositories.product.RepositoryProduct
import com.colodin.mvicompose.services.data.SProductFull
import com.colodin.mvicompose.services.data.SProductShort

class RepositoryProductTestImpl : RepositoryProduct, RepositoryProductHelper {

    private var testProductShorts:List<SProductShort>? = emptyList()
    override var productShorts: List<SProductShort>?
        get() = testProductShorts
        set(value) {
            testProductShorts = value
        }

    private var testFullProduct: SProductFull? = null
    override var productFull: SProductFull?
        get() = testFullProduct
        set(value) {
            testFullProduct = value
        }

    override suspend fun getProducts(): List<SProductShort> {
        return testProductShorts!!
    }

    override suspend fun getProduct(id: Int): SProductFull {
        return testFullProduct!!
    }
}