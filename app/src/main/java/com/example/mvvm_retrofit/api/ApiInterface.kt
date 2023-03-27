package com.example.mvvm_retrofit.api

import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET("/top-headlines")
    suspend fun getTopHeadlines(): Response<com.example.mvvm_retrofit.model.Response>

}