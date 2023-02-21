package com.expv1n.mynewsapplication.data

import com.expv1n.mynewsapplication.data.database.ArticleEntity
import com.expv1n.mynewsapplication.data.models.Article
import com.expv1n.mynewsapplication.data.models.Source

class ArticleMapper {

    fun modelToEntity(article: Article) = ArticleEntity(
        id = 0,
        author = article.author,
        content = article.content,
        description = article.description,
        publishedAt = article.publishedAt,
        title = article.title,
        url = article.url,
        urlToImage = article.urlToImage,
        isFavorite = false
    )

    fun entityToModel(article: ArticleEntity) = Article(
        author = article.author,
        content = article.content,
        description = article.description,
        publishedAt = article.publishedAt,
        title = article.title,
        url = article.url,
        urlToImage = article.urlToImage,
        source = Source("", "")
    )

}