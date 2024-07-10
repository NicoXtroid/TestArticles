package com.example.testnote.ui.article

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testnote.data.model.RemoteArticle
import com.example.testnote.ui.navigation.NavGo

@Composable
fun ArticleScreen(article: RemoteArticle, navGo: NavGo) {
    val context = LocalContext.current
    val exoPlayer = ExoPLayer.Builder(context).build()

    Scaffold { it ->
        Column(
            modifier = Modifier
                .padding(horizontal = 22.dp)
                .padding(top = 36.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(text = article.title, fontSize = 28.sp, fontWeight = FontWeight.W600)
            Text(text = article.date, fontSize = 14.sp, fontWeight = FontWeight.W400)
            Text(text = article.author, fontSize = 14.sp, fontWeight = FontWeight.W600)
            Text(
                text = article.note,
                modifier = Modifier.padding(top = 10.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.W400
            )
            Text(text = article.videoUrl, fontSize = 14.sp, fontWeight = FontWeight.W400)
        }
    }
}