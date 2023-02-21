package com.expv1n.mynewsapplication.data

import android.app.Application
import com.expv1n.mynewsapplication.data.database.AppDatabase
import com.expv1n.mynewsapplication.data.database.ArticleEntity
import com.expv1n.mynewsapplication.data.models.Article
import com.expv1n.mynewsapplication.domain.Repository

class RepositoryImpl(application: Application): Repository {

    private val apiFactory = ApiFactory()
    private val databaseDao = AppDatabase.getInstance(application).getArticleDao()
    private val mapper = ArticleMapper()


    override suspend fun getNews(): List<Article> {
        val apiService = apiFactory.apiService.getNews()
        return apiService.articles
    }

    override suspend fun addToFavorite(article: Article) {
        databaseDao.addToFavorite(mapper.modelToEntity(article))
    }

    override suspend fun removeFromFavorite(id: Int) {
        databaseDao.removeFromFavorite(id)
    }

    override suspend fun getFavoriteList(): List<ArticleEntity> {
        return databaseDao.getArticleList()
    }
}