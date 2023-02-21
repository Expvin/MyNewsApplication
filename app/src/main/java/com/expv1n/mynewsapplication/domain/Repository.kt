package com.expv1n.mynewsapplication.domain

import com.expv1n.mynewsapplication.data.database.ArticleEntity
import com.expv1n.mynewsapplication.data.models.Article

interface Repository {

    suspend fun getNews(): List<Article>

    suspend fun addToFavorite(article: Article)

    suspend fun removeFromFavorite(id: Int)

    suspend fun getFavoriteList(): List<ArticleEntity>

}