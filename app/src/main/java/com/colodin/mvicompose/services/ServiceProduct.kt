package com.colodin.mvicompose.services

import com.colodin.mvicompose.services.data.SProductFull
import com.colodin.mvicompose.services.data.SProductShort

interface ServiceProduct {

    /**
     *
     *
     */
    suspend fun getProducts(): List<SProductShort>

    /**
     *
     *
     */
    suspend fun getProduct(id: Int): SProductFull
}