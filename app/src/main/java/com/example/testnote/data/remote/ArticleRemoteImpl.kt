package com.example.testnote.data.remote

import com.example.testnote.data.model.RemoteArticleList
import com.example.testnote.data.remote.retrofit.ArticleWebService
import com.example.testnote.data.source.ArticleSourceRemote

internal class ArticleRemoteImpl(
    private val webService: ArticleWebService
) : ArticleSourceRemote {
    override suspend fun getArticleList(): RemoteArticleList {
        return webService.getArticleList()
    }
}

