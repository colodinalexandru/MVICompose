package com.colodin.mvicompose.dummy

import android.annotation.SuppressLint
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.google.gson.JsonSyntaxException
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import timber.log.Timber

class HelperLogger : HttpLoggingInterceptor.Logger, KoinComponent {
    private val gsonManager: Gson by inject()

    @SuppressLint("BinaryOperationInTimber")
    override fun log(message: String) {
        val logName = "ApiLogger"
        if (message.startsWith("{") || message.startsWith("[")) {
            try {
                val prettyPrintJson = gsonManager.toJson(JsonParser.parseString(message))
                Timber.d("$logName  $prettyPrintJson")
            } catch (m: JsonSyntaxException) {
                Timber.d("$logName  $message")
            }
        } else {
            Timber.d("$logName  $message")
            return
        }
    }
}