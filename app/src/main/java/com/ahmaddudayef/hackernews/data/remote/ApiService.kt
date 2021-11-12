package com.ahmaddudayef.hackernews.data.remote

import com.ahmaddudayef.hackernews.data.remote.model.Article
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("/v0/topstories.json?print=pretty")
    suspend fun getTopStories(): List<Int>

    @GET("/v0/item/{id}.json?print=pretty")
    suspend fun getArticle(@Path("id") id: String): Article

}