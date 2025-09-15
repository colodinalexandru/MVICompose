package com.colodin.mvicompose

import com.colodin.mvicompose.base.domain.ActionType

interface AppProcessorAction {
    val actions: MutableList<ActionType>
}