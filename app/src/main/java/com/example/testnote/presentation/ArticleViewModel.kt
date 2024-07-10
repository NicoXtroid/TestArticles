package com.example.testnote.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testnote.data.MockArticleRepository
import com.example.testnote.data.model.RemoteArticleList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleViewModel(private val articleRepository: MockArticleRepository) : ViewModel() {

    private val _articleList = MutableStateFlow<RemoteArticleList?>(null)
    val articleList: StateFlow<RemoteArticleList?> get() = _articleList

    init {
        viewModelScope.launch {
            _articleList.value = articleRepository.getArticleList()
        }
    }
}