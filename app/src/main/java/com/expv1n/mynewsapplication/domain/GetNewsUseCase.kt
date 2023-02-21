package com.expv1n.mynewsapplication.domain

import com.expv1n.mynewsapplication.data.models.Article

class GetNewsUseCase(private val repository: Repository) {

    suspend fun get(): List<Article> {
        return repository.getNews().toList()
    }

}