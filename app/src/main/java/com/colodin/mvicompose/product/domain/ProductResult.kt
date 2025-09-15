package com.colodin.mvicompose.product.domain

import com.colodin.mvicompose.base.domain.ResultType
import com.colodin.mvicompose.product.data.QAProductFull
import com.colodin.mvicompose.product.data.QAProductShort

sealed class ProductResult : ResultType {

    /**
     *
     * [ProductProcessor.onProductActionInit]
     * [ProductState.productItems]
     */
    class ProductResultItems(val productItems: List<QAProductShort>) : ProductResult()

    /**
     *
     * [ProductProcessor.onProductActionInit]
     * [ProductState.productShowProgress]
     */
    class ProductResultProductShowProgress(val productShowProgress: Boolean) : ProductResult()

    /**
     *
     * [ProductProcessor.onProductActionInit]
     * [ProductState.productErrorMessage]
     */
    class ProductResultProductErrorMessage(val productErrorMessage: String) : ProductResult()


    /**
     *
     * [ProductProcessor.onProductActionFullProduct]
     * [ProductState.fullProduct]
     */
    class ProductResultFullProduct(val fullProduct: QAProductFull) : ProductResult()

}