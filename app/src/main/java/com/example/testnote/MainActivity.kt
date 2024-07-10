package com.example.testnote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.testnote.data.MockArticleRepository
import com.example.testnote.presentation.ArticleViewModel
import com.example.testnote.presentation.ArticleViewModelFactory
import com.example.testnote.ui.articlelist.ArticleListScreen
import com.example.testnote.ui.navigation.NavController
import com.example.testnote.ui.theme.TestnoteTheme

class MainActivity : ComponentActivity() {

    private lateinit var viewModel: ArticleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val useMockData = true

        val articleRepository = MockArticleRepository(this)
        viewModel = ViewModelProvider(this, ArticleViewModelFactory(articleRepository))
            .get(ArticleViewModel::class.java)

        setContent {
            TestnoteTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val x = innerPadding
                    NavController(articleListViewModel = viewModel)

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestnoteTheme {
        Greeting("Android")
    }
}