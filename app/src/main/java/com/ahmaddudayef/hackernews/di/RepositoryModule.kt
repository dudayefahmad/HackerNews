package com.ahmaddudayef.hackernews.di

import com.ahmaddudayef.hackernews.data.remote.repository.ArticleRepository
import com.ahmaddudayef.hackernews.data.remote.source.ArticleDataSource
import org.koin.dsl.module

val repositoryModule = module {
    single { ArticleRepository(get()) as ArticleDataSource }
}