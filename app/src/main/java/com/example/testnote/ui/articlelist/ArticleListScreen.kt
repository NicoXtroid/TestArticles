package com.example.testnote.ui.articlelist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.testnote.presentation.ArticleViewModel
import com.example.testnote.ui.articlelist.components.ArticleComponent
import com.example.testnote.ui.navigation.NavGo

@Composable
fun ArticleListScreen(viewModel: ArticleViewModel, modifier: Modifier = Modifier, navGo: NavGo) {
    val articles by viewModel.articleList.collectAsState()

    articles?.let { articlesList ->
        Column(modifier = Modifier.verticalScroll(rememberScrollState())
            .fillMaxSize()
            .padding(top = 30.dp), ) {
            for (article in articlesList) {
                ArticleComponent(article = article, navGo = navGo)
            }
        }
    }

}