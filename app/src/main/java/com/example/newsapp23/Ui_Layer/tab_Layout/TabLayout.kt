package com.example.newsapp23.Ui_Layer.tab_Layout



import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf

import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.newsapp23.Ui_Layer.Home_Screen.NewsList
import com.example.newsapp23.Ui_Layer.View_Model.viewModel




@Composable
fun TabLayout(VM: viewModel,navController: NavController) {
    val tabItemsList=
        listOf(
            TabItem(
                title = "Top Headline",
                selectedColor = Color.Gray,
                unselectedColor = Color.Black
            ),
            TabItem(
                title = "Sports",
                selectedColor = Color.Gray,
                unselectedColor = Color.Black
            ),
            TabItem(
                title = "Technology",
                selectedColor = Color.Gray,
                unselectedColor = Color.Black
            ),
        )
    var selectedTabIndex by remember {
        mutableIntStateOf(0) }
    val pageState =rememberPagerState{tabItemsList.size}
    LaunchedEffect(selectedTabIndex) {
        pageState.animateScrollToPage(selectedTabIndex)
    }
    LaunchedEffect(pageState.currentPage,pageState.isScrollInProgress) {
        if (!pageState.isScrollInProgress){
            selectedTabIndex = pageState.currentPage
        }
    }
    Column (
        modifier = Modifier.fillMaxSize()
    ){
        TabRow(contentColor =Color.Black,
            selectedTabIndex = selectedTabIndex) {
            tabItemsList.forEachIndexed { index, tabItem ->
                Tab(selected = selectedTabIndex == index, onClick = { selectedTabIndex = index }) {
                    Text(
                        text = "${tabItemsList[index].title}",
                        color = if(selectedTabIndex == index)
                            tabItemsList[index].selectedColor
                        else
                            tabItemsList[index].unselectedColor
                    )
                }
            }
        }
        HorizontalPager(state = pageState) {index->
            Box(modifier = Modifier.fillMaxSize()){
                var category = when(tabItemsList[index].title){
                    "Technology" -> "technology"
                    "Sports" -> "sports"
                    else -> null
                }
                LaunchedEffect(key1 = Unit) {
                   VM.getTopNews(category)

                }
                NewsList(VM = VM, navController = navController)
            }

        }
    }

}