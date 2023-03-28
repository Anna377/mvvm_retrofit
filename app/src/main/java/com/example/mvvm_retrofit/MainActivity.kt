package com.example.mvvm_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_retrofit.api.ApiInterface
import com.example.mvvm_retrofit.api.ApiUtilities
import com.example.mvvm_retrofit.repository.UsersRepository
import com.example.mvvm_retrofit.viewmodel.UsersViewModel
import com.example.mvvm_retrofit.viewmodel.UsersViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var usersViewModel: UsersViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiInterface = ApiUtilities.getInstance().create(ApiInterface::class.java)
        val usersRepository = UsersRepository(apiInterface)

        usersViewModel =
            ViewModelProvider(this, UsersViewModelFactory(usersRepository)).get(
                UsersViewModel::class.java
            )

        usersViewModel.users.observe(this) { it ->
            it.results.iterator().forEach {user ->
                Log.d("TAG1", "name: ${user.name}: ${user.email}")

            }

        }
    }
}