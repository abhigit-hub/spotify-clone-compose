package com.abhigit.spotifyclone.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.abhigit.spotifyclone.screens.composables.*
import com.abhigit.spotifyclone.ui.navy_blue_dark
import com.abhigit.spotifyclone.ui.navy_blue_light
import com.abhigit.spotifyclone.viewmodel.SpotifyViewModel

@Composable
fun SpotifyScreen(
    viewModel: SpotifyViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.linearGradient(
                    listOf(
                        navy_blue_light,
                        navy_blue_dark
                    ),
                    start = Offset(0f, 0f),
                    end = Offset(200f, 1000f)
                )
            )
    ) {
        Column() {
            SpotifyTopBar()
            Box() {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(bottom = 80.dp)
                        .align(Alignment.Center)
                ) {
                    RecentGrid(viewModel.recentPlayedItems.value)
                    viewModel.newReleaseSection.value?.let { NewReleaseSection(it) }
                    viewModel.showSuggestions.value?.let { ShowSuggestionSection(it) }
                    viewModel.topMixes.value?.let { TopMixesSection(it) }
                    viewModel.artists.value?.let { FavoriteArtistsSection(it) }
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                ) {
                    SpotifyBottomBar()
                }
            }
        }
    }
}