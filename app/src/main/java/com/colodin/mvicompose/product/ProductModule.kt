package com.colodin.mvicompose.product


import com.colodin.mvicompose.product.data.HProduct
import com.colodin.mvicompose.product.data.HProductImpl
import com.colodin.mvicompose.product.domain.ProductProcessor
import com.colodin.mvicompose.product.domain.ProductReducer
import com.colodin.mvicompose.product.presentation.ProductViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ProductModule = module {

    single<HProduct> { HProductImpl() }

    single { ProductProcessor() }

    single { ProductReducer() }

    viewModel{ ProductViewModel(get())}
}