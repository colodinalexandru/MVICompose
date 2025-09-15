package com.colodin.mvicompose

import com.colodin.mvicompose.base.domain.ProcessorResultCallback
import com.colodin.mvicompose.base.domain.ResultType

class MockProcessorResultCallback: ProcessorResultCallback {
    val results = mutableListOf<ResultType>()
    override fun invoke(p1: ResultType) {
        results.add(p1)
    }
}