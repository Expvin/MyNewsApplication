package com.expv1n.mynewsapplication.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "article_favorite")
data class ArticleEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val title: String?,
    val url: String?,
    val urlToImage: String?,
    val isFavorite: Boolean = false
)