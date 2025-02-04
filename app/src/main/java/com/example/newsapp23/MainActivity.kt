package com.example.newsapp23

import android.annotation.SuppressLint
import android.os.Bundle

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels

import androidx.compose.foundation.layout.fillMaxSize


import androidx.compose.material3.Scaffold

import androidx.compose.ui.Modifier

import com.example.newsapp23.Ui_Layer.View_Model.viewModel
import com.example.newsapp23.Ui_Layer.navigation.NavHostController


import com.example.newsapp23.ui.theme.NewsApp23Theme

class MainActivity : ComponentActivity() {

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        val VM by viewModels<viewModel>()
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NewsApp23Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    innerPadding
                    // News(title = "",imageUrl = "",desp = "")

                    NavHostController(VM)
// HomeScreen(viewModel = viewModel)

                }
            }
        }
    }
}

