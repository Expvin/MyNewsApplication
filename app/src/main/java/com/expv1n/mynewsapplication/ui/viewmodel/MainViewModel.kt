package com.expv1n.mynewsapplication.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.expv1n.mynewsapplication.data.RepositoryImpl
import com.expv1n.mynewsapplication.data.models.Article
import com.expv1n.mynewsapplication.domain.GetNewsUseCase
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private val repository = RepositoryImpl()
    private val getNewsUseCase =  GetNewsUseCase(repository)
    private val _newsLiveDate = MutableLiveData<List<Article>>()
    val newsLiveData: LiveData<List<Article>>
        get() = _newsLiveDate

    suspend fun getNews() {
        viewModelScope.launch {
            val list = getNewsUseCase.get()
            _newsLiveDate.value = list
        }
    }
}