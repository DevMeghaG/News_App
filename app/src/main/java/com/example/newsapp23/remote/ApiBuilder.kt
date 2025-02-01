package com.example.newsapp23.remote


import retrofit2.Retrofit.*
import retrofit2.converter.gson.GsonConverterFactory

object ApiBuilder {
    fun provideApi(): ApiServiice {
        return Builder().baseUrl("https://newsapi.org/v2/").addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiServiice::class.java)

    }
}