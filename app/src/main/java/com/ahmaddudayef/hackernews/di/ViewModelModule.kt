package com.ahmaddudayef.hackernews.di

import com.ahmaddudayef.hackernews.presentation.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }

}