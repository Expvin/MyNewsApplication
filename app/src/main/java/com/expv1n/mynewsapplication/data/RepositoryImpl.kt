package com.expv1n.mynewsapplication.data

import com.expv1n.mynewsapplication.data.models.Article
import com.expv1n.mynewsapplication.domain.Repository

class RepositoryImpl: Repository {

    private val apiFactory =  ApiFactory()

    override suspend fun getNews(): List<Article> {
        val apiService = apiFactory.apiService.getNews()
        return apiService.articles
    }
}