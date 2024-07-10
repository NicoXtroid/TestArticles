package com.example.testnote.data

import android.content.Context
import com.example.testnote.data.model.RemoteArticleList
import com.example.testnote.data.source.ArticleSourceRemote
import com.google.gson.Gson
import java.io.IOException

class MockArticleRepository(private val context: Context) : ArticleSourceRemote {
    override suspend fun getArticleList(): RemoteArticleList {
        val jsonString = readJsonFromAssets(context, "articles.json")
        return Gson().fromJson(jsonString, RemoteArticleList::class.java)
    }

    private fun readJsonFromAssets(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }
}