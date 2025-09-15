package com.colodin.mvicompose.product.domain

import com.colodin.mvicompose.base.domain.StateType
import com.colodin.mvicompose.base.utilis.OneTimeEvent
import com.colodin.mvicompose.product.data.QAProductFull
import com.colodin.mvicompose.product.data.QAProductShort

data class ProductState(

    /**
     *
     * [ProductProcessor.onProductActionInit]
     * [ProductResult.ProductResultItems]
     */
    val productItems: OneTimeEvent<List<QAProductShort>>? = null,

    /**
     *
     * [ProductProcessor.onProductActionInit]
     * [ProductResult.ProductResultProductShowProgress]
     */
    val productShowProgress: OneTimeEvent<Boolean>? = null,

    /**
     *
     * [ProductProcessor.onProductActionInit]
     * [ProductResult.ProductResultProductErrorMessage]
     */
    val productErrorMessage: OneTimeEvent<String>? = null,

    /**
     *
     * [ProductProcessor.onProductActionFullProduct]
     * [ProductResult.ProductResultFullProduct]
     */
    val fullProduct: OneTimeEvent<QAProductFull>? = null,


    ) : StateType