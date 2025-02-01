package com.example.newsapp23.remote

import com.example.newsapp23.model.NewsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServiice {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = "07431f6d78d94398afe132959d8b269f"
    ): NewsModel

    @GET("top-headlines")
    suspend fun getCategoryNews(
        @Query("country") country: String = "us",
        @Query("category") category: String,
        @Query("apiKey") apiKey: String = "07431f6d78d94398afe132959d8b269f"
    ): NewsModel
}