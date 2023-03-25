package com.abhigit.spotifyclone.screens.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.abhigit.spotifyclone.model.ShowItem
import com.abhigit.spotifyclone.model.Shows
import com.abhigit.spotifyclone.ui.SpotifyTypography

@Composable
fun ShowSuggestionSection(shows: Shows) {
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        SectionHeader(shows.showMetaData)
        ShowSuggestionList(shows.shows)
    }
}

@Composable
private fun ShowSuggestionList(shows: List<ShowItem>) {
    LazyRow {
        items(shows) { item ->
            SuggestionItem(item)
        }
    }
}

@Composable
fun SuggestionItem(item: ShowItem) {
    Column {
        Image(
            rememberImagePainter(data = item.showImageUrl),
            contentDescription = item.showName,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .height(220.dp)
                .width(220.dp)
                .padding(top = 20.dp, end = 20.dp)
                .clip(RoundedCornerShape(10.dp))
        )

        Text(
            text = item.showLabel,
            color = Color.Green,
            style = SpotifyTypography.body1,
            modifier = Modifier.padding(top = 10.dp)
        )

        Text(
            text = item.showName,
            color = Color.White,
            style = SpotifyTypography.subtitle1,
            modifier = Modifier
                .width(220.dp)
                .height(40.dp)
                .padding(top = 10.dp, end = 10.dp)
        )

        Text(
            text = item.showDescription,
            color = Color.Gray,
            style = SpotifyTypography.body2,
            modifier = Modifier
                .height(80.dp)
                .width(220.dp)
                .padding(top = 5.dp, end = 10.dp)
        )
    }
}