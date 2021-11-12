package com.ahmaddudayef.hackernews.di

import com.ahmaddudayef.hackernews.BuildConfig
import com.ahmaddudayef.hackernews.data.remote.ApiService
import com.google.gson.Gson
import okhttp3.Dispatcher
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {

    single(named("logging")) {
        HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
            level =
                if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        } as Interceptor
    }

    single {
        val dispatcher = Dispatcher()
        dispatcher.maxRequestsPerHost = 10
        OkHttpClient.Builder()
            .addInterceptor(get<Interceptor>(named("logging")))
            .dispatcher(dispatcher)
            .connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS).writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(get() as Gson))
            .client(get() as OkHttpClient)
            .build()
            .create(ApiService::class.java)
    }
}