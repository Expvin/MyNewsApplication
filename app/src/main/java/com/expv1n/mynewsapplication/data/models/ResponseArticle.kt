package com.expv1n.mynewsapplication.data.models

data class ResponseArticle(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)