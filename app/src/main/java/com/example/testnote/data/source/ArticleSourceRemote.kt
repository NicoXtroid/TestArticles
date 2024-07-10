package com.example.testnote.data.source

import com.example.testnote.data.model.RemoteArticleList

interface ArticleSourceRemote {
    suspend fun getArticleList(): RemoteArticleList
}