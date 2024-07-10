package com.example.testnote.data.remote.retrofit
import com.example.testnote.data.model.RemoteArticleList
import retrofit2.http.GET

interface ArticleWebService {
    @GET()
    suspend fun getArticleList() : RemoteArticleList
}