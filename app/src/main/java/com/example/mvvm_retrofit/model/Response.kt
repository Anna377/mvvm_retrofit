package com.example.mvvm_retrofit.model

data class Response(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)