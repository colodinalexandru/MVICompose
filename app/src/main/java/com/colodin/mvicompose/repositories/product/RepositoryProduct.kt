package com.colodin.mvicompose.repositories.product

import com.colodin.mvicompose.services.data.SProductFull
import com.colodin.mvicompose.services.data.SProductShort

interface RepositoryProduct {

    /**
     *
     * [RepositoryProductImpl.getProducts]
     *
     */
    suspend fun getProducts(): List<SProductShort>

    /**
     *
     * [RepositoryProductImpl.getProduct]
     */
    suspend fun getProduct(id: Int): SProductFull
}