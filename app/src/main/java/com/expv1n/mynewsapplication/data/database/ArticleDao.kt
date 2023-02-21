package com.expv1n.mynewsapplication.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.expv1n.mynewsapplication.data.models.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToFavorite(article: ArticleEntity)

    @Query("SELECT * FROM article_favorite")
    suspend fun getArticleList(): List<ArticleEntity>

    @Query("DELETE FROM article_favorite WHERE id=:articleId")
    suspend fun removeFromFavorite(articleId: Int)

}