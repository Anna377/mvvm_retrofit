package com.example.mvvm_retrofit.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvm_retrofit.api.ApiInterface
import com.example.mvvm_retrofit.model.Data

class UsersRepository(private val apiInterface: ApiInterface){

    private val usersLiveData = MutableLiveData<Data>()
    val users : LiveData<Data>
    get() = usersLiveData

    suspend fun getUsers(){
        val result = apiInterface.getUsers()
        if (result.body() != null){
            usersLiveData.postValue(result.body())
        }
    }

}