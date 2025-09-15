package com.colodin.mvicompose.assay

import android.content.Context
import com.colodin.mvicompose.BuildConfig
import com.colodin.mvicompose.assay.data.ASProduct
import com.colodin.mvicompose.assay.impls.AssayServiceProductImpl
import com.colodin.mvicompose.services.ServiceProduct
import com.parse.Parse
import com.parse.ParseObject
import org.koin.dsl.module

fun initParser(context: Context, applicationId:String) {
    if (BuildConfig.DEBUG) {
        Parse.setLogLevel(Parse.LOG_LEVEL_DEBUG)
    }

    ParseObject.registerSubclass(ASProduct::class.java)
    Parse.initialize(
        Parse.Configuration.Builder(context)
            .applicationId(applicationId)
            .server(BuildConfig.PARSE_URL)
            .build()
    )
}

val AssayModule = module {
    single<ServiceProduct> { AssayServiceProductImpl() }
}