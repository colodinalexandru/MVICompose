package com.colodin.mvicompose.dummy

import com.colodin.mvicompose.BuildConfig
import com.colodin.mvicompose.dummy.adapter.JSONDProductModelAdapter
import com.colodin.mvicompose.dummy.data.DProductModel
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private val gsonManager: Gson by lazy {
    val gsonBuilder = GsonBuilder()

    gsonBuilder.registerTypeAdapter(DProductModel::class.java, JSONDProductModelAdapter())

    gsonBuilder.setLenient()
    gsonBuilder.create()
}


val NetworkModule = module {



    single { gsonManager }

    single {
        HttpLoggingInterceptor(HelperLogger()).setLevel(
            if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        )
    }

    single {
        OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(get<HttpLoggingInterceptor>())
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .client(get())
            .baseUrl(BuildConfig.DUMMY_URL)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .build()
    }

    single<DummyService> {
        val retrofit = get<Retrofit>()
        retrofit.create(DummyService::class.java)
    }
}