package com.example.contextualcards.models

data class FormattedDescription(
    val align: String,
    val entities: List<Any>,
    val text: String
)