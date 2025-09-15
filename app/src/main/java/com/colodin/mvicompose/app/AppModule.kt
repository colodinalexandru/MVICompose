package com.colodin.mvicompose.app

import com.colodin.mvicompose.app.domain.AppController
import com.colodin.mvicompose.app.domain.AppControllerImpl
import com.colodin.mvicompose.app.domain.AppProcessor
import com.colodin.mvicompose.app.domain.AppReducer
import com.colodin.mvicompose.app.domain.AppState
import com.colodin.mvicompose.product.domain.ProductProcessor
import org.koin.dsl.module

val AppModule = module {

    single<AppController> { AppControllerImpl(get(), get(), get()) }

    single { AppProcessor(get()) }

    single { AppState() }

    single { listOf(get<ProductProcessor>()) }

    single { AppReducer(initialState = get(), productReducer = get()) }
}