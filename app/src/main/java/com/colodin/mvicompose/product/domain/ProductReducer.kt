package com.colodin.mvicompose.product.domain

import com.colodin.mvicompose.base.domain.ReducerType
import com.colodin.mvicompose.base.domain.ResultType
import com.colodin.mvicompose.base.utilis.OneTimeEvent

class ProductReducer : ReducerType<ProductState> {

    override fun reduce(result: ResultType, state: ProductState): ProductState {
        if (result !is ProductResult) {
            return state
        }

        return when (result) {
            is ProductResult.ProductResultItems -> state.copy(productItems = OneTimeEvent(result.productItems))
            is ProductResult.ProductResultProductShowProgress -> state.copy(productShowProgress = OneTimeEvent(result.productShowProgress))
            is ProductResult.ProductResultProductErrorMessage -> state.copy(productErrorMessage = OneTimeEvent(result.productErrorMessage))

            is ProductResult.ProductResultFullProduct -> state.copy(fullProduct = OneTimeEvent(result.fullProduct))
        }
    }

}