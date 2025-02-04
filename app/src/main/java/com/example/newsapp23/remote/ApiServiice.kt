package com.example.newsapp23.remote


import com.example.newsapp23.model.NewsModel
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {

    @GET("top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = "cccf54d319934db2bb8b035838d21711"
    ): NewsModel

    @GET("top-headlines")
    suspend fun getCategoryNews(
        @Query("country") country: String = "us",
        @Query("category") category: String?,
        @Query("apiKey") apiKey: String = "cccf54d319934db2bb8b035838d21711"
    ): NewsModel
}