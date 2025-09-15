package com.colodin.mvicompose.app.domain

import com.colodin.mvicompose.base.domain.StateType
import com.colodin.mvicompose.product.domain.ProductState

data class AppState(val productState: ProductState = ProductState()) : StateType