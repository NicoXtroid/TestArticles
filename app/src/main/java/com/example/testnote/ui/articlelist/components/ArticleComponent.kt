package com.example.testnote.ui.articlelist.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testnote.data.model.RemoteArticle
import com.example.testnote.ui.article.ArticleScreen
import com.example.testnote.ui.navigation.NavGo

@Composable
fun ArticleComponent(article: RemoteArticle, navGo: NavGo) {
    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .fillMaxWidth()
            .border(width = 1.dp, color = Color.Cyan)
            .clickable(onClick = {
                navGo.articleDetail.invoke(article)
            })
    ) {
        Column(
            modifier = Modifier
                .padding(3.dp)
        ) {
            Text(text = article.title, fontSize = 24.sp, fontWeight = FontWeight.W600, fontStyle = FontStyle.Italic)
            Text(
                text = article.note,
                modifier = Modifier.padding(top = 5.dp),
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                maxLines = 4
            )
            Text(
                text = "Continuar leyendo...",
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                maxLines = 4
            )
        }
    }

}