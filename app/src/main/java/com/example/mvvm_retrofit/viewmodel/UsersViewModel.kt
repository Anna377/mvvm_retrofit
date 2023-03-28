package com.example.mvvm_retrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvm_retrofit.model.Data
import com.example.mvvm_retrofit.repository.UsersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UsersViewModel (private val usersRepository: UsersRepository): ViewModel(){

    init{
        viewModelScope.launch(Dispatchers.IO){
            usersRepository.getUsers()
        }

    }

    val users : LiveData<Data>
    get() = usersRepository.users

}