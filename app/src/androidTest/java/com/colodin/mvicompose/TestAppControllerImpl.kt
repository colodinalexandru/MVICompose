package com.colodin.mvicompose

import androidx.lifecycle.MutableLiveData
import com.colodin.mvicompose.app.domain.AppController
import com.colodin.mvicompose.app.domain.AppState
import com.colodin.mvicompose.base.domain.ActionType

class TestAppControllerImpl(initialState: AppState) : AppController,AppProcessorAction {

    private val actionsList = mutableListOf<ActionType>()
    override var state = MutableLiveData<AppState>().apply {
        value = initialState
    }

    override fun dispatch(action: ActionType) {
        actionsList.add(action)
    }
    override val actions: MutableList<ActionType>
        get() = actionsList

}