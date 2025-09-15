package com.colodin.mvicompose

import com.colodin.mvicompose.app.domain.AppController
import com.colodin.mvicompose.app.domain.AppReducer
import com.colodin.mvicompose.app.domain.AppState
import org.koin.dsl.binds
import org.koin.dsl.module

val AppModuleTest = module {

    single{ TestAppControllerImpl(get()) } binds arrayOf(AppController::class,AppProcessorAction::class)
    single { AppState() }
    single {
        AppReducer(
            initialState = get(),
            productReducer = get()
        )
    }


}