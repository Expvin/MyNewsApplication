package com.expv1n.mynewsapplication.domain

import com.expv1n.mynewsapplication.data.ArticleMapper
import com.expv1n.mynewsapplication.data.models.Article

class GetFavoriteListUseCase(val repository: Repository, val mapper: ArticleMapper) {

    suspend fun getFavoriteList(): List<Article> {
        val list = repository.getFavoriteList()
        return list.map { mapper.entityToModel(it) }
    }


}