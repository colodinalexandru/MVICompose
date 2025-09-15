package com.colodin.mvicompose.product.domain

import com.colodin.mvicompose.MockProcessorResultCallback
import com.colodin.mvicompose.product.data.HProduct
import com.colodin.mvicompose.product.data.HProductImpl
import com.colodin.mvicompose.product.data.QAProductFull
import com.colodin.mvicompose.product.data.QAProductShort
import com.colodin.mvicompose.repositories.product.RepositoryProduct
import com.colodin.mvicompose.services.data.SProductFull
import com.colodin.mvicompose.services.data.SProductShort
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import org.koin.core.context.GlobalContext
import org.koin.dsl.binds
import org.koin.dsl.module
import java.math.BigDecimal
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class ProductProccesorTest : KoinComponent {

    private val helperRepositoryProduct by inject<RepositoryProductHelper>()

    private val testProcessor by inject<ProductProcessor>()
    private val callback by inject<MockProcessorResultCallback>()

    private val templateSProductShort by lazy {
        SProductShort(id = 0, title = "title", price = BigDecimal.ONE, rating = BigDecimal.ONE, thumbnail = "")
    }

    private val templateSProductFull by lazy {
        SProductFull(
            id = 0,
            title = "title",
            description = "description",
            price = BigDecimal.ONE,
            discountPercentage = BigDecimal.ONE,
            rating = BigDecimal.ONE,
            stock = 0,
            category = "category",
            thumbnail = "",
            images = emptyList()
        )
    }

    @Before
    fun setUp() {
        GlobalContext.startKoin {
            modules(module {

                single<HProduct> { HProductImpl() }
                single { RepositoryProductTestImpl() }.binds(arrayOf(RepositoryProduct::class, RepositoryProductHelper::class))
                single { ProductProcessor() }
                single { MockProcessorResultCallback() }

            })
        }
    }

    @After
    fun tearDown() {
        GlobalContext.stopKoin()
    }

    @Test
    fun onProductActionInit_error() = runBlocking {
        helperRepositoryProduct.productShorts = null
        testProcessor.process(ProductAction.ProductActionInit, callback)

        val results = callback.results
        assertTrue(results.count() == 3)

        val productResultProductShowProgressTrue = results[0] as ProductResult.ProductResultProductShowProgress
        assertTrue(productResultProductShowProgressTrue.productShowProgress)

        val productResultProductErrorMessage = results[1] as ProductResult.ProductResultProductErrorMessage
        assertEquals("Something wrong try again later", productResultProductErrorMessage.productErrorMessage)

        val productResultProductShowProgressFalse = results[2] as ProductResult.ProductResultProductShowProgress
        assertFalse(productResultProductShowProgressFalse.productShowProgress)
    }

    @Test
    fun onProductActionInit_empty() = runBlocking {
        testProcessor.process(ProductAction.ProductActionInit, callback)
        val results = callback.results
        assertTrue(results.count() == 3)

        val productResultProductShowProgressTrue = results[0] as ProductResult.ProductResultProductShowProgress
        assertTrue(productResultProductShowProgressTrue.productShowProgress)

        val productResultProductErrorMessage = results[1] as ProductResult.ProductResultProductErrorMessage
        assertEquals("No products in stock", productResultProductErrorMessage.productErrorMessage)

        val productResultProductShowProgressFalse = results[2] as ProductResult.ProductResultProductShowProgress
        assertFalse(productResultProductShowProgressFalse.productShowProgress)
    }

    @Test
    fun onProductActionInit() = runBlocking {

        helperRepositoryProduct.productShorts = listOf(templateSProductShort, templateSProductShort.copy(id = 1, title = "title 1"))

        testProcessor.process(ProductAction.ProductActionInit, callback)
        val results = callback.results
        assertTrue(results.count() == 3)

        val productResultProductShowProgressTrue = results[0] as ProductResult.ProductResultProductShowProgress
        assertTrue(productResultProductShowProgressTrue.productShowProgress)

        val outputItems = listOf(QAProductShort(id = 0, title = "title", price = "$1.00", rating = 1.00f, thumbnail = ""), QAProductShort(id = 1, title = "title 1", price = "$1.00", rating = 1.00f, thumbnail = ""))
        val productResultItems = results[1] as ProductResult.ProductResultItems
        assertContentEquals(outputItems, productResultItems.productItems)

        val productResultProductShowProgressFalse = results[2] as ProductResult.ProductResultProductShowProgress
        assertFalse(productResultProductShowProgressFalse.productShowProgress)
    }

    @Test
    fun onProductActionFullProduct_error() = runBlocking {

        testProcessor.process(ProductAction.ProductActionFullProduct(0), callback)

        val results = callback.results
        assertTrue(results.count() == 3)

        val productResultProductShowProgressTrue = results[0] as ProductResult.ProductResultProductShowProgress
        assertTrue(productResultProductShowProgressTrue.productShowProgress)

        val productResultProductErrorMessage = results[1] as ProductResult.ProductResultProductErrorMessage
        assertEquals("Something wrong try again later", productResultProductErrorMessage.productErrorMessage)

        val productResultProductShowProgressFalse = results[2] as ProductResult.ProductResultProductShowProgress
        assertFalse(productResultProductShowProgressFalse.productShowProgress)
    }

    @Test
    fun onProductActionFullProduct() = runBlocking {

        helperRepositoryProduct.productFull = templateSProductFull
        testProcessor.process(ProductAction.ProductActionFullProduct(0), callback)

        val results = callback.results
        assertTrue(results.count() == 3)

        val productResultProductShowProgressTrue = results[0] as ProductResult.ProductResultProductShowProgress
        assertTrue(productResultProductShowProgressTrue.productShowProgress)

        val outPut = QAProductFull(
            id = 0,
            title = "title",
            description = "description",
            price = "$1.00",
            discountPercentage = "1.00%",
            rating = 1.00f,
            stock = "0.00",
            category = "category",
            images = emptyList()
        )

        val productResultFullProduct = results[1] as ProductResult.ProductResultFullProduct
        assertEquals(outPut, productResultFullProduct.fullProduct)

        val productResultProductShowProgressFalse = results[2] as ProductResult.ProductResultProductShowProgress
        assertFalse(productResultProductShowProgressFalse.productShowProgress)
    }


}