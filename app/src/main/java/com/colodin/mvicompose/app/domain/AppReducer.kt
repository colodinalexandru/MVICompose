package com.colodin.mvicompose.app.domain

import com.colodin.mvicompose.base.domain.ReducerType
import com.colodin.mvicompose.base.domain.ResultType
import com.colodin.mvicompose.product.domain.ProductReducer

class AppReducer(private val initialState: AppState, private val productReducer: ProductReducer) : ReducerType<AppState> {
    override fun reduce(result: ResultType, state: AppState): AppState {
        return when (result) {
            is AppResult.ResetAppState -> initialState
            else -> AppState(productState = productReducer.reduce(result = result, state = state.productState))
        }
    }

}