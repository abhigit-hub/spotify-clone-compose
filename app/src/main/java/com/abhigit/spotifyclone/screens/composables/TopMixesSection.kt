package com.abhigit.spotifyclone.screens.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.abhigit.spotifyclone.model.TopMixes
import com.abhigit.spotifyclone.model.TopMixesItem
import com.abhigit.spotifyclone.ui.SpotifyTypography
import com.abhigit.spotifyclone.utils.ColorUtils
import kotlinx.coroutines.launch

@Composable
fun TopMixesSection(topMixes: TopMixes) {
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        SectionHeader(header = topMixes.topMixesMetaData)
        TopMixesList(topMixes.topMixes)
    }
}

@Composable
private fun TopMixesList(topMixes: List<TopMixesItem>) {
    LazyRow {
        items(topMixes) { item ->
            TopMixesItem(item)
        }
    }
}

@Composable
private fun TopMixesItem(item: TopMixesItem) {
    var dominantColor by remember { mutableStateOf(Color.Black) }
    val painter = rememberImagePainter(data = item.topMixesImageUrl)

    Column {
        Box(
            modifier = Modifier
                .height(220.dp)
                .width(220.dp)
                .padding(top = 20.dp, end = 20.dp)
        ) {
            Image(
                painter,
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center)
                    .alpha(0.3f)
            )

            LaunchedEffect(key1 = painter) {
                launch {
                    val image = painter.imageLoader.execute(painter.request).drawable
                    image?.let { drawable ->
                        ColorUtils.calculateDominantColor(drawable) { color ->
                            dominantColor = color
                        }
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 20.dp)
                    .background(Color.Black.copy(alpha = 0.5f))
            ) {
                Box(modifier = Modifier
                    .height(30.dp)
                    .width(7.dp)
                    .background(dominantColor)
                )
                Text(
                    text = item.topMixesName,
                    color = Color.White,
                    style = SpotifyTypography.subtitle1,
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .align(CenterVertically)
                )
            }

            Box(modifier = Modifier
                .height(7.dp)
                .fillMaxWidth()
                .background(dominantColor)
                .align(Alignment.BottomCenter)
            )
        }
        Text(
            text = item.topMixesDescription,
            color = Color.Gray,
            style = SpotifyTypography.subtitle2,
            modifier = Modifier
                .height(40.dp)
                .width(220.dp)
                .padding(top = 10.dp, end = 10.dp)
        )
    }
}