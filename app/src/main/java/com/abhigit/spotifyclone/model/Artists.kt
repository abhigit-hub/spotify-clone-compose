package com.abhigit.spotifyclone.model

data class ArtistItem(
    val artistName: String = "",
    val artistImageUrl: String = ""
)

data class Artists(
    val artists: List<ArtistItem>,
    val artistMetaData: String = ""
)