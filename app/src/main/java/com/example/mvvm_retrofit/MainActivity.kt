package com.example.mvvm_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_retrofit.api.ApiInterface
import com.example.mvvm_retrofit.api.ApiUtilities
import com.example.mvvm_retrofit.repository.ArticlesRepository
import com.example.mvvm_retrofit.viewmodel.ArticlesViewModel
import com.example.mvvm_retrofit.viewmodel.ArticlesViewModelFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {

    private lateinit var articlesViewModel: ArticlesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val apiInterface = ApiUtilities.getInstance().create(ApiInterface::class.java)
        val articlesRepository = ArticlesRepository(apiInterface)

        articlesViewModel =
            ViewModelProvider(this, ArticlesViewModelFactory(articlesRepository)).get(
                ArticlesViewModel::class.java
            )

        articlesViewModel.articles.observe(this) { it ->
            it.articles.iterator().forEach{ article ->
                Log.d("TAG1", "name: ${article.title}: ${article.url}")

            }

        }
    }
}