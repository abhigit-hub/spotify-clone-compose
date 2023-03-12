package com.example.codelabs.model

data class TrackItem(
    val artistName: String = "",
    val artistImageUrl: String = "",
    val albumName: String = "",
    val albumImageUrl: String = "",
    val isLiked: Boolean = true,
    val trackMetaData: String = ""
)