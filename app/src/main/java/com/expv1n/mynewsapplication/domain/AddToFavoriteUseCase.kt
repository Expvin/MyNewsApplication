package com.expv1n.mynewsapplication.domain

import com.expv1n.mynewsapplication.data.models.Article

class AddToFavoriteUseCase(val repository: Repository) {

    suspend fun addToFavorite(article: Article) {
        repository.addToFavorite(article)
    }


}