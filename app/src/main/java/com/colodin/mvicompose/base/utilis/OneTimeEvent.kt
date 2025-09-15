package com.colodin.mvicompose.base.utilis

import java.util.concurrent.atomic.AtomicBoolean

class OneTimeEvent<T>(private val data: T) {

    private val pending = AtomicBoolean(true)

    fun consume(): T? {
        if (pending.compareAndSet(true, false)) {
            return data
        }
        return null
    }

    /**
     *
     * No recommend for use it, better to use MediatorLiveData
     */
    fun peek(): T {
        return data
    }
}