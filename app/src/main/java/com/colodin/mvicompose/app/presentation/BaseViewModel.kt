package com.colodin.mvicompose.app.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.colodin.mvicompose.app.domain.AppController
import com.colodin.mvicompose.app.domain.AppState
import com.colodin.mvicompose.base.domain.ActionType

abstract class BaseViewModel(private val appController: AppController) : ViewModel() {

    val state: LiveData<AppState> = appController.state


    fun dispatch(action: ActionType) {
        appController.dispatch(action)
    }

}