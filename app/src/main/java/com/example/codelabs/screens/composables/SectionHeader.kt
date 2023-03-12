package com.example.codelabs.screens.composables

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.example.codelabs.ui.SpotifyTypography

@Composable
fun SectionHeader(header: String) {
    Text(
        text = header,
        style = SpotifyTypography.h1,
        color = Color.White
    )
}