package com.abhigit.spotifyclone.screens.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.abhigit.spotifyclone.model.BottomMenuContent
import com.abhigit.spotifyclone.R

@Composable
fun SpotifyBottomBar() {
    BottomMenu(
        items = listOf(
            BottomMenuContent("Home", R.drawable.ic_home),
            BottomMenuContent("Search", R.drawable.ic_search),
            BottomMenuContent("Your Library", R.drawable.ic_music),
        ), modifier = Modifier
    )
}