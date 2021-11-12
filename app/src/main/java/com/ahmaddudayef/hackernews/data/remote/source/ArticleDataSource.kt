package com.ahmaddudayef.hackernews.data.remote.source

import com.ahmaddudayef.hackernews.data.remote.model.Article

interface ArticleDataSource {

    suspend fun getTopStories(): List<Int>

    suspend fun getArticle(id: String): Article

}