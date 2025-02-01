package com.example.newsapp23.Ui_Layer.View_Model


import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope


import com.example.newsapp23.model.NewsModel
import com.example.newsapp23.remote.ApiBuilder
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

class viewModel:ViewModel() {

    var data = mutableStateOf<NewsModel?>(null)

    fun getTopNews(category: String?){
        viewModelScope.launch {

            data.value =  ApiBuilder.provideApi().getTopHeadlines()
        }
    }
    fun formatDate(isoDate: String): String {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        inputFormat.timeZone = TimeZone.getTimeZone("UTC")
        val outputFormat = SimpleDateFormat("dd-MM-yy", Locale.getDefault())
        val date = inputFormat.parse(isoDate)
        return date?.let { outputFormat.format(it) } ?: "Invalid Date"
    }


}