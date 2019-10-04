package com.julienarzul.kotlinmultiplatform.sample.androidapp

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import devfest.domain.MovieRepository
import devfest.hello
import devfest.network.MovieApiService
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository =
            MovieRepository(MovieApiService(BuildConfig.API_BASE_URL, BuildConfig.API_KEY))

        findViewById<TextView>(R.id.textView).text = hello()

        lifecycleScope.launch {
            val movieList = repository.discoverMovies()
            Log.d("MainActivity", "Movie list: $movieList")
        }
    }
}
