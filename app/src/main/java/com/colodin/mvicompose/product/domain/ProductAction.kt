package com.colodin.mvicompose.product.domain

import com.colodin.mvicompose.base.domain.ActionType

sealed class ProductAction : ActionType {

    /**
     *
     * [ProductProcessor.onProductActionInit]
     */
    object ProductActionInit : ProductAction()

    /**
     *
     *  [ProductProcessor.onProductActionFullProduct]
     */
    class ProductActionFullProduct(val productId:Int): ProductAction()
}