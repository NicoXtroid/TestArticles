package com.example.testnote.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.testnote.presentation.ArticleViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun NavController(articleListViewModel: ArticleViewModel) {
    val startDestination: String = NavRoutes.ArticlesListScreen.routes

    val navController = rememberNavController()
    val navGo = remember(navController) { NavGo(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        articlesListScreen(
            viewModel = articleListViewModel,
            navGo = navGo
        )
        articleScreen(
            navController = navController,
            navGo = navGo
        )
    }
}