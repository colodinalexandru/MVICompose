package com.colodin.mvicompose.product.domain

import com.colodin.mvicompose.base.domain.ActionType
import com.colodin.mvicompose.base.domain.ProcessorResultCallback
import com.colodin.mvicompose.base.domain.ProcessorType
import com.colodin.mvicompose.base.utilis.toCurrencyString
import com.colodin.mvicompose.base.utilis.toStringWithLocal
import com.colodin.mvicompose.base.utilis.toStringWithPercent
import com.colodin.mvicompose.product.data.HProduct
import com.colodin.mvicompose.product.data.QAProductFull
import com.colodin.mvicompose.product.data.QAProductShort
import com.colodin.mvicompose.repositories.product.RepositoryProduct
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import timber.log.Timber
import java.math.BigDecimal
import java.util.Locale

class ProductProcessor : ProcessorType, KoinComponent {

    private val repositoryProduct: RepositoryProduct by inject()
    private val hProduct: HProduct by inject()

    override suspend fun process(action: ActionType, next: ProcessorResultCallback) {
        if (action !is ProductAction) {
            return
        }

        when (action) {
            is ProductAction.ProductActionInit -> {
                onProductActionInit(next)
            }

            is ProductAction.ProductActionFullProduct -> {
                onProductActionFullProduct(action.productId, next)
            }
        }
    }

    private suspend fun onProductActionInit(next: ProcessorResultCallback) {
        next(ProductResult.ProductResultProductShowProgress(true))
        try {
            val products = repositoryProduct.getProducts()
            if (products.isEmpty()) {
                next(ProductResult.ProductResultProductErrorMessage("No products in stock"))
                return
            }

            // no info about the currency or rate change
            val productItems = products.map { QAProductShort(id = it.id, title = it.title, price = it.price.toCurrencyString(Locale.US), rating = it.rating.toFloat(), thumbnail = it.thumbnail) }
            next(ProductResult.ProductResultItems(productItems))

        } catch (e: Exception) {
            next(ProductResult.ProductResultProductErrorMessage("Something wrong try again later"))
            Timber.e(e)
        } finally {
            next(ProductResult.ProductResultProductShowProgress(false))
        }
    }

    private suspend fun onProductActionFullProduct(productId: Int, next: ProcessorResultCallback) {

        Timber.d("-----onProductActionFullProduct-> productID", productId)
        next(ProductResult.ProductResultProductShowProgress(true))
        try {
            val product = repositoryProduct.getProduct(productId)
            val productFull = QAProductFull(
                id = product.id,
                title = product.title,
                description = product.description,
                price = product.price.toCurrencyString(Locale.US),
                discountPercentage = product.discountPercentage.toStringWithPercent(Locale.US),
                rating = product.rating.toFloat(),
                stock = BigDecimal(product.stock).toStringWithLocal(Locale.US),
                category = product.category,
                images = hProduct.getImagesWithoutThumbnail(product.images)
            )

            next(ProductResult.ProductResultFullProduct(productFull))
        } catch (e: Exception) {
            next(ProductResult.ProductResultProductErrorMessage("Something wrong try again later"))
            Timber.e(e)
        } finally {
            next(ProductResult.ProductResultProductShowProgress(false))
        }

    }
}