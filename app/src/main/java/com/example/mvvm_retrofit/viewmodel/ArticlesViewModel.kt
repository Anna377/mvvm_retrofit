package com.example.mvvm_retrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_retrofit.model.Response
import com.example.mvvm_retrofit.repository.ArticlesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArticlesViewModel (private val articlesRepository: ArticlesRepository): ViewModel(){

    init{
        viewModelScope.launch(Dispatchers.IO){
            articlesRepository.getArticles()
        }

    }

    val articles : LiveData<Response>
    get() = articlesRepository.articles

}