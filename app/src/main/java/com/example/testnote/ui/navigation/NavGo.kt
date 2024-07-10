package com.example.testnote.ui.navigation

import androidx.navigation.NavHostController
import com.example.testnote.data.model.RemoteArticle

class NavGo(navHostController:NavHostController) {

    val articleDetail: (RemoteArticle) -> Unit = { article ->
        navHostController.currentBackStackEntry?.savedStateHandle?.set("title", article.title)
        navHostController.currentBackStackEntry?.savedStateHandle?.set("date", article.date)
        navHostController.currentBackStackEntry?.savedStateHandle?.set("author", article.author)
        navHostController.currentBackStackEntry?.savedStateHandle?.set("note", article.note)
        navHostController.currentBackStackEntry?.savedStateHandle?.set("videoUrl", article.videoUrl)
        navHostController.navigate(NavRoutes.ArticlesScreen.routes)
    }

    val popBackStack: () -> Unit = {
        navHostController.popBackStack()
    }
}