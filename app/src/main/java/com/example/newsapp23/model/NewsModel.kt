package com.example.newsapp23.model

data class NewsModel(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)