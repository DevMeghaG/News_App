package com.example.newsapp23.Ui_Layer.Home_Screen
import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

import com.example.newsapp23.Ui_Layer.View_Model.viewModel
import com.example.newsapp23.Ui_Layer.tab_Layout.TabLayout
import com.example.newsapp23.model.NewsModel
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel: viewModel, navController: NavHostController) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            // Content inside the drawer
            ModalDrawerSheet(
                drawerContainerColor = Color.White
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Red)
                ) {

                }
            }
        }
    ) {
        Scaffold(
            topBar = {

                CenterAlignedTopAppBar(
                    title = {
                        Text(text = "LATEST NEWS")
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.open()
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = ""
                            )

                        }
                    },
                    actions = {
                        IconButton(onClick = {
                            // Handle search icon click
                        }) {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = "Search"
                            )
                        }
                    }

                )
            }
        ) { paddingValues ->
            var data = remember {
                mutableStateOf<NewsModel?>(null)
            }
            // GlobalScope.launch { data.value= ApiBuilder.provideApi().getEverythingNews() }
            // Main screen content

            Box(modifier = Modifier.padding(paddingValues)) {
                TabLayout(VM =viewModel(), navController = navController)
            }
        }
    }
}