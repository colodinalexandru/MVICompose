package com.colodin.mvicompose.product.data

import org.junit.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertTrue

class HProductTest {
    private val testProduct: HProduct = HProductImpl()

    @Test
    fun getImagesWithoutThumbnail_empty() {
        val result = testProduct.getImagesWithoutThumbnail(emptyList())
        assertTrue(result.isEmpty())
    }

    @Test
    fun getImagesWithoutThumbnail() {
        val input = listOf(
            "https://i.dummyjson.com/data/products/1/1.jpg",
            "https://i.dummyjson.com/data/products/1/thumbnail.jpg",
        )
        val result = testProduct.getImagesWithoutThumbnail(input)
        assertContentEquals(listOf("https://i.dummyjson.com/data/products/1/1.jpg"),result)
    }
}