package com.abhigit.spotifyclone.screens.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.abhigit.spotifyclone.model.BottomMenuContent
import com.abhigit.spotifyclone.ui.notification_bottom_bar

@Composable
fun BottomMenu(
    items: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = Color.Gray,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember { mutableStateOf(initialSelectedItemIndex) }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(notification_bottom_bar)
    ) {
        items.forEachIndexed { index, bottomMenuContent ->
            BottomMenuItem(
                item = bottomMenuContent,
                isSelected = index == selectedItemIndex,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor,
            ) {
                selectedItemIndex = index
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean = false,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = Color.Gray,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .defaultMinSize(200.dp, 60.dp)
            .clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .padding(15.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }

        Text(
            text = item.title,
            color = if (isSelected) activeTextColor else inactiveTextColor,
            modifier = Modifier.padding(bottom = 10.dp)
        )
    }
}