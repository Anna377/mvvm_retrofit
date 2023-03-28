package com.example.mvvm_retrofit.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

//    @GET("v2/top-headlines")
    @GET("api")
    suspend fun getUsers(
//        @Query("country")
//        countryCode: String = "us",
//        @Query("page")
//        pageNumber: Int = 1,
//        @Query("apiKey")
//        apiKey: String = "19660c5e80044aa5b6fd0e85b3377907"
        @Query("inc")
        countryCode: String = "nat,name,email",
        @Query("results")
        pageNumber: Int = 100,
    ): Response<com.example.mvvm_retrofit.model.Data>


}