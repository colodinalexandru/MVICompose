package com.colodin.mvicompose.dummy

import com.colodin.mvicompose.dummy.data.DProductModel
import com.colodin.mvicompose.dummy.data.DProductResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DummyService {

    @GET("product")
    suspend fun getProducts(): DProductResponse

    @GET("product/{id}")
    suspend fun getProduct(@Path("id") id: Int): DProductModel
}