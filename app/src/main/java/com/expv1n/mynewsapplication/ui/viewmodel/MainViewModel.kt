package com.expv1n.mynewsapplication.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.expv1n.mynewsapplication.data.ArticleMapper
import com.expv1n.mynewsapplication.data.RepositoryImpl
import com.expv1n.mynewsapplication.data.models.Article
import com.expv1n.mynewsapplication.domain.AddToFavoriteUseCase
import com.expv1n.mynewsapplication.domain.GetFavoriteListUseCase
import com.expv1n.mynewsapplication.domain.GetNewsUseCase
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val mapper = ArticleMapper()
    private val repository = RepositoryImpl(application)
    private val getNewsUseCase = GetNewsUseCase(repository)
    private val addToFavoriteUseCase = AddToFavoriteUseCase(repository)
    private val getFavoriteListUseCase = GetFavoriteListUseCase(repository, mapper)

    private val _newsLiveDate = MutableLiveData<List<Article>>()
    val newsLiveData: LiveData<List<Article>>
        get() = _newsLiveDate

    private val _favoriteNewsLiveData = MutableLiveData<List<Article>>()
    val favoriteNewsLiveData: LiveData<List<Article>>
        get() = _favoriteNewsLiveData

    suspend fun getFavoriteList() {
        viewModelScope.launch {
            val list = getFavoriteListUseCase.getFavoriteList()
            _favoriteNewsLiveData.value = list
        }
    }

    suspend fun getNews() {
        viewModelScope.launch {
            val list = getNewsUseCase.get()
            _newsLiveDate.value = list
        }
    }

    suspend fun addToFavorite(article: Article) {
        viewModelScope.launch {
            addToFavoriteUseCase.addToFavorite(article)
        }
    }

}