package com.example.codelabs.screens.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.codelabs.model.TrackItem
import com.example.codelabs.ui.SpotifyTypography
import com.example.codelabs.ui.bg_card

@Composable
fun NewReleaseSection(
    trackItem: TrackItem
) {
    Column(modifier = Modifier.padding(20.dp)) {
        NewReleaseHeader(trackItem)
        Spacer(modifier = Modifier.size(20.dp))
        SongTileMain(trackItem)
    }
}

@Composable
fun NewReleaseHeader(trackItem: TrackItem) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
       Image(
           painter = rememberImagePainter(data = trackItem.artistImageUrl),
           contentDescription = "",
           modifier = Modifier
               .clip(CircleShape)
               .size(120.dp)
       )
       Column(
           verticalArrangement = Arrangement.Center,
           modifier = Modifier
               .padding(10.dp)
       ) {
           Text(
               text = trackItem.trackMetaData.uppercase(),
               style = SpotifyTypography.body1,
               color = Color.Gray,
               modifier = Modifier.padding(5.dp)
           )
           Text(
               text = trackItem.artistName,
               style = SpotifyTypography.h1,
               color = Color.White,
               modifier = Modifier.padding(5.dp)
           )
       }
    }
}

@Composable
fun SongTileMain(trackItem: TrackItem) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) {
        Row(
            modifier = Modifier
                .background(color = bg_card)
                .fillMaxWidth()
        ) {
           Image(
               painter = rememberImagePainter(data = trackItem.albumImageUrl),
               contentDescription = "",
           )
           Column(
               modifier = Modifier
                   .fillMaxSize()
                   .padding(20.dp),
               horizontalAlignment = Alignment.Start,
               verticalArrangement = Arrangement.Top
           ) {
               Text(
                   text = trackItem.albumName.uppercase(),
                   style = SpotifyTypography.subtitle1,
                   color = Color.White,
                   modifier = Modifier.padding(5.dp)
               )
               Text(
                   text = "Album • " + trackItem.artistName,
                   style = SpotifyTypography.body1,
                   color = Color.Gray,
                   modifier = Modifier.padding(5.dp)
               )
               Row(
                   horizontalArrangement = Arrangement.SpaceBetween,
                   verticalAlignment = Alignment.Bottom,
                   modifier = Modifier.fillMaxSize()
               ) {
                   Icon(
                       Icons.Filled.Favorite,
                       contentDescription = "",
                       tint = Color.Green,
                       modifier = Modifier.size(45.dp)
                   )
                   Icon(
                       Icons.Filled.PlayArrow,
                       contentDescription = "",
                       modifier = Modifier
                           .size(50.dp)
                           .shadow(shape = CircleShape, elevation = 5.dp)
                           .background(Color.White)
                           .padding(10.dp)
                   )
               }
           }
        }
    }
}