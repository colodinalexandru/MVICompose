package com.colodin.mvicompose.app.domain

import com.colodin.mvicompose.base.domain.ResultType

sealed class AppResult: ResultType {
    object ResetAppState: AppResult()
}