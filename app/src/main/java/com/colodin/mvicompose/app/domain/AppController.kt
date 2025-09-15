package com.colodin.mvicompose.app.domain

import androidx.lifecycle.MutableLiveData
import com.colodin.mvicompose.base.domain.ActionType

interface AppController {

    var state: MutableLiveData<AppState>

    fun dispatch(action: ActionType)
}