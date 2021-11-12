package com.ahmaddudayef.hackernews.data.remote.model

data class Article (
    var by: String,
    var descendants: Int,
    var id: Int,
    var kids: ArrayList<Int>,
    var score: Int,
    var time: Int,
    var title: String,
    var type: String,
    var url: String
)