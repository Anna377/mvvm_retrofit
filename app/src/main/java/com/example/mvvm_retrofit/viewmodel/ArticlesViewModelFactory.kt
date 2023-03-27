package com.example.mvvm_retrofit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_retrofit.repository.ArticlesRepository

class ArticlesViewModelFactory(private val articlesRepository: ArticlesRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ArticlesViewModel(articlesRepository) as T
    }


}
