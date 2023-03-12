package com.example.codelabs.model

data class TopMixesItem(
    val topMixesName: String = "",
    val topMixesDescription: String = "",
    val topMixesImageUrl: String = ""
)

data class TopMixes(
    val topMixes: List<TopMixesItem>,
    val topMixesMetaData: String = ""
)