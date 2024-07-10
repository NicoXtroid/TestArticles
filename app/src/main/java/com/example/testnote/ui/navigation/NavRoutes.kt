package com.example.testnote.ui.navigation

sealed class NavRoutes(var routes:String) {
    object ArticlesListScreen: NavRoutes("ArticlesListScreen")
    object ArticlesScreen: NavRoutes("ArticlesScreen")
}