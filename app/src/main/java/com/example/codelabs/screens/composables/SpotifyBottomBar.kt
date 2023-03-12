package com.example.codelabs.screens.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.codelabs.model.BottomMenuContent
import com.example.codelabs.R

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