package com.example.newsapp23.Ui_Layer.navigation

import kotlinx.serialization.Serializable


@Serializable
object HomeScreenRout

@Serializable
data class SingleNewsRout(
    val title : String,
    val desp : String?,
    val imageUrl : String?,
    val newsUrl : String,
    val dateAndTime : String
)