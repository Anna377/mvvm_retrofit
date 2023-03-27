package com.example.mvvm_retrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_retrofit.api.ApiInterface
import com.example.mvvm_retrofit.model.Response

class ArticlesRepository(private val apiInterface: ApiInterface){

    private val articlesLiveData = MutableLiveData<Response>()
    val articles : LiveData<Response>
    get() = articlesLiveData

    suspend fun getArticles(){
        val result = apiInterface.getTopHeadlines()
        if (result.body() != null){
            articlesLiveData.postValue(result.body())
        }
    }

}