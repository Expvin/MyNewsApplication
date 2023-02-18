package com.expv1n.mynewsapplication.data

import com.expv1n.mynewsapplication.data.models.ResponseArticle
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("v2/top-headlines")
    suspend fun getNews(
        @Query("country") country: String = "ru",
        @Query("apiKey") apiKey: String = "b346887532b6459babc71cf72cc916e2"
    ): ResponseArticle

    companion object {
        private const val API_KEY = "b346887532b6459babc71cf72cc916e2"
        private const val URL = "https://newsapi.org/v2/top-headlines?country=ru&apiKey=b346887532b6459babc71cf72cc916e2"
    }
}