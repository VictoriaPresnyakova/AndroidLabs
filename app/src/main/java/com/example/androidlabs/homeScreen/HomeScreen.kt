package com.example.androidlabs.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androidlabs.R
import com.example.androidlabs.homeScreen.CardItem.HotelCard
import com.example.androidlabs.Hotel
import com.example.androidlabs.homeScreen.SearchField.SearchField

@Composable
fun HomeScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Box(modifier = Modifier
            .background(colorResource(id = R.color.figma_blue))
            .fillMaxHeight(0.18f)
        ){
            Column(
                modifier = Modifier
                    .fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ){
                Text(text= "Beautiful Place to Live", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                    color = Color.White)
                Text(text="Find a Source you want to spent times", color = Color.White)
                SearchField(
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 20.dp),

                ) { searchText ->
                    // Обработка введенного текста поиска
                }
            }
        }
        LazyColumn (
            modifier = Modifier
                //.verticalScroll(rememberScrollState())
        ){
            items(count = 100 ){
                HotelCard(Hotel("hotel", R.drawable.img, it % 6, "location", "info", 4000), navController)
            }

        }
    }
}
@Preview(showBackground = true)
@Composable
fun HotelPreview() {
    var nc = rememberNavController()
    HomeScreen(nc)
}