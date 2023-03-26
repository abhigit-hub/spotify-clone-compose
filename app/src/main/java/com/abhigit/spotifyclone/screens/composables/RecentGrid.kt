package com.abhigit.spotifyclone.screens.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.abhigit.spotifyclone.model.RecentPlayedItem
import com.abhigit.spotifyclone.ui.SpotifyTypography
import com.abhigit.spotifyclone.ui.bg_card

@Composable
fun RecentGrid(
    items: List<RecentPlayedItem>
) {
    for (i in 0 until items.size / 2) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            RecentItem(item = items[i*2], modifier = Modifier.weight(0.5f))
            RecentItem(item = items[i*2 + 1], modifier = Modifier.weight(0.5f))
        }
    }
}

@Composable
fun RecentItem(item: RecentPlayedItem, modifier: Modifier) {
    Card(
        shape = RoundedCornerShape(10.dp),
        backgroundColor = bg_card,
        modifier = modifier
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .height(80.dp)
            .shadow(elevation = 15.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = rememberImagePainter(data = item.itemUrl),
                contentDescription = "1",
                modifier = Modifier
                    .fillMaxHeight()
                    .width(80.dp)
            )
            Text(
                text = item.itemName,
                color = Color.White,
                style = SpotifyTypography.subtitle1,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(10.dp)
                    .align(Alignment.CenterVertically)

            )
        }
    }
}