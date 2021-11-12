package com.ahmaddudayef.hackernews.presentation.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmaddudayef.hackernews.data.State
import com.ahmaddudayef.hackernews.data.remote.model.Article
import com.ahmaddudayef.hackernews.data.remote.source.ArticleDataSource
import kotlinx.coroutines.launch

class HomeViewModel(
    private val articleRepository: ArticleDataSource
) : ViewModel() {

    val listArticleState = MutableLiveData<State<List<Article>>>()

    init {
        getListArticle()
    }

    private fun getListArticle() {
        listArticleState.postValue(State.Loading())
        viewModelScope.launch {
            try {
                val topCategories = articleRepository.getTopStories()

            } catch (e: Exception) {
                listArticleState.postValue(State.Error(e))
            }
        }
    }
}