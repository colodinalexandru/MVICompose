package com.colodin.mvicompose.app.domain

import androidx.lifecycle.MutableLiveData
import com.colodin.mvicompose.base.domain.ActionType
import com.colodin.mvicompose.base.domain.ResultType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors

class AppControllerImpl(
    private val processor: AppProcessor,
    private val reducer: AppReducer,
    initialState: AppState
) : CoroutineScope by CoroutineScope(Executors.newSingleThreadExecutor().asCoroutineDispatcher()), AppController {

    private val sharedFlow = MutableSharedFlow<ResultType>(0, 10)
    private val eventSharedFlow = sharedFlow.asSharedFlow()

    override var state = MutableLiveData<AppState>().apply {
        value = initialState
    }

    init {

        launch(Dispatchers.IO) {
            eventSharedFlow.collect { result ->
                val v = state.value ?: return@collect
                val newState = reducer.reduce(result, v)
                withContext(Dispatchers.Main) {
                    state.value = newState
                }
            }
        }
    }

    override fun dispatch(action: ActionType) {
        launch(Dispatchers.IO) {
            processor.process(action) { result ->
                sharedFlow.tryEmit(result)
            }
        }
    }

}