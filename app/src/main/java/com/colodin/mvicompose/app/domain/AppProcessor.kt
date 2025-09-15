package com.colodin.mvicompose.app.domain

import com.colodin.mvicompose.base.domain.ActionType
import com.colodin.mvicompose.base.domain.ProcessorResultCallback
import com.colodin.mvicompose.base.domain.ProcessorType

class AppProcessor(private val processors: List<ProcessorType>) : ProcessorType {

    override suspend fun process(action: ActionType, next: ProcessorResultCallback) {
        for (processor in processors) {
            processor.process(action, next)
        }
    }
}