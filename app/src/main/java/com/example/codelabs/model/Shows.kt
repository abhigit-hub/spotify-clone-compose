package com.example.codelabs.model

data class ShowItem(
    val showName: String = "",
    val showDescription: String = "",
    val showLabel: String = "",
    val showImageUrl: String = ""
)

data class Shows(
    val shows: List<ShowItem>,
    val showMetaData: String = ""
)