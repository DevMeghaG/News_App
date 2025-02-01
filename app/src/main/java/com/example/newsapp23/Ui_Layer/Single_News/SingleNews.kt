package com.example.newsapp23.Ui_Layer.Single_News



import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil3.Uri
import coil3.compose.AsyncImage


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SingleNews(
    title: String,
    imageUrl: String?,
    desp: String?,
    newsUrl: String,
    dateAndTime: String,
    navController: NavController,
) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    titleContentColor = Color.Black,
                    navigationIconContentColor = Color.Black
                ),

                title = { Text(text = "NEWS", fontFamily = FontFamily.Serif) },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigateUp()
                    }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowLeft,
                            contentDescription = ""
                        )

                    }
                }

            )
        }
    ) {
        it

        Box(modifier = Modifier
            .padding(it)
            .background(MaterialTheme.colorScheme.primary)) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)

            ) {
                Text(
                    text = title,
                    fontSize = 23.sp,
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black

                )

//            if (!imageUrl.isNullOrEmpty()){
//                AsyncImage(model = imageUrl, contentDescription = null)
//            }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AsyncImage(
                        modifier = Modifier
                            .height(200.dp)
                            .width(300.dp),
                        model = imageUrl, contentDescription = ""
                    )
                }

                desp?.let {
                    Text(
                        text = desp,
                        fontSize = 20.sp,
                        color = Color.Black,
                        fontFamily = FontFamily.Serif,
                    )
                }


            }

            Button(
                modifier = Modifier
                    .fillMaxWidth(.9f)
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 15.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                shape = RoundedCornerShape(5.dp),
                onClick = {
                    val intent = Intent(Intent.ACTION_VIEW, android.net.Uri.parse(newsUrl))
                    context.startActivity(intent)

                }
            ) {
                Text(
                    text = "READ FULL ARTICLE",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontFamily = FontFamily.SansSerif,
                )
            }

        }
    }
}