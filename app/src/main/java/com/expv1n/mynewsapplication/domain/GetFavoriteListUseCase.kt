package com.expv1n.mynewsapplication.domain

import com.expv1n.mynewsapplication.data.database.ArticleEntity

class GetFavoriteListUseCase(val repository: Repository) {

    suspend fun getFavoriteList(): List<ArticleEntity> {
        return repository.getFavoriteList()
    }


}