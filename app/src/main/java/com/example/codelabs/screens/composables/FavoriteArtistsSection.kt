package com.example.codelabs.screens.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.codelabs.model.ArtistItem
import com.example.codelabs.model.Artists
import com.example.codelabs.ui.SpotifyTypography

@Composable
fun FavoriteArtistsSection(artists: Artists) {
    Column(
        modifier = Modifier.padding(20.dp)
    ) {
        SectionHeader(header = artists.artistMetaData)
        FavoriteArtistsList(artistItems = artists.artists)
    }
}

@Composable
private fun FavoriteArtistsList(artistItems: List<ArtistItem>) {
    LazyRow {
        items(artistItems) { item ->
            FavoriteArtistItem(artistItem = item)
        }
    }
}

@Composable
private fun FavoriteArtistItem(artistItem: ArtistItem) {
    Column(
        modifier = Modifier.padding(end = 20.dp, top = 20.dp)
    ) {
        Image(
            rememberImagePainter(data = artistItem.artistImageUrl),
            contentDescription = "",
            modifier = Modifier
                .clip(CircleShape)
                .height(200.dp)
                .width(200.dp)
        )
        Text(
            text = artistItem.artistName,
            color = Color.White,
            style = SpotifyTypography.subtitle1,
            modifier = Modifier.padding(top = 20.dp).align(CenterHorizontally)
        )
    }
}