package com.example.codelabs.screens.composables

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material.icons.outlined.History
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.codelabs.ui.SpotifyTypography
import com.example.codelabs.ui.notification_dot

@Composable
fun SpotifyTopBar() {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Good evening",
            color = Color.White,
            style = SpotifyTypography.h1,
            modifier = Modifier
                .weight(0.85f)
                .padding(20.dp)
        )
        Box(
            modifier = Modifier
                .size(30.dp)
                .weight(0.05f)
                .align(Alignment.CenterVertically)
        ) {
            Icon(
                Icons.Outlined.Notifications,
                contentDescription = "notification",
                tint = Color.White,
                modifier = Modifier
                    .size(30.dp)
            )

            Icon(
                Icons.Filled.Circle,
                contentDescription = "",
                modifier = Modifier.size(10.dp),
                tint = notification_dot
            )
        }
        Icon(
            Icons.Outlined.History,
            contentDescription = "history",
            tint = Color.White,
            modifier = Modifier
                .size(30.dp)
                .weight(0.05f)
                .align(Alignment.CenterVertically)
        )
        Icon(
            Icons.Outlined.Settings,
            contentDescription = "settings",
            tint = Color.White,
            modifier = Modifier
                .size(30.dp)
                .weight(0.05f)
                .align(Alignment.CenterVertically)
        )
    }
}