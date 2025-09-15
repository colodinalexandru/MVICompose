package com.colodin.mvicompose.base.domain


typealias ProcessorResultCallback = (ResultType) -> Unit

interface ProcessorType {
    suspend fun process(action: ActionType, next: ProcessorResultCallback)
}