package com.ahmaddudayef.hackernews

import android.app.Application
import com.ahmaddudayef.hackernews.di.*
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            modules(
                arrayListOf(
                    appModule, viewModelModule, repositoryModule, networkModule
                )
            )
        }
    }

}