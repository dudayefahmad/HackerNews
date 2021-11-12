package com.ahmaddudayef.hackernews.data.remote.repository

import com.ahmaddudayef.hackernews.data.remote.ApiService
import com.ahmaddudayef.hackernews.data.remote.model.Article
import com.ahmaddudayef.hackernews.data.remote.source.ArticleDataSource

class ArticleRepository(private val apiService: ApiService): ArticleDataSource {

    override suspend fun getTopStories(): List<Int> {
        return apiService.getTopStories()
    }

    override suspend fun getArticle(id: String): Article {
        return apiService.getArticle(id)
    }


}