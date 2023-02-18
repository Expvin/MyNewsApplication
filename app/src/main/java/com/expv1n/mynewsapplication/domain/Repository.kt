package com.expv1n.mynewsapplication.domain

import com.expv1n.mynewsapplication.data.models.Article

interface Repository {

    suspend fun getNews(): List<Article>

}