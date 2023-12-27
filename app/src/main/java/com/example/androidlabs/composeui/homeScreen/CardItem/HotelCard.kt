package com.example.androidlabs.composeui.homeScreen.CardItem

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.androidlabs.DB.models.Hotel
import com.example.androidlabs.R
import com.google.gson.Gson

@Composable
fun HotelCard (hotel: Hotel, navController: NavHostController){
    androidx.compose.material.Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                val hotelItemString = Gson().toJson(hotel)
                navController.navigate("HotelInfo/${hotelItemString}")
            },
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
        ) {
        Box(
            modifier = Modifier.background(Color.White)
        ) {
            Row(
                modifier = Modifier
                    //.background(Color.Yellow)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically

            ) {
                Image(
                    painter = painterResource(id = hotel.img),
                    contentDescription = "hotel",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .padding(4.dp)
                        .size(150.dp)

                )
                Column(
                    modifier = Modifier
                        //.background(Color.Red)
                        .padding(start = 20.dp),
                    //horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {
                    Text(text = hotel.name, fontSize = 40.sp, fontWeight = FontWeight.Bold)
                    Row() {
                        for (i in 1..hotel.stars){
                            Image(
                                painter = painterResource(id = R.drawable.star_rate),
                                contentDescription = "star",
                                modifier = Modifier
                                    .size(20.dp)
                            )
                        }
                        for (i in 1.. 5 - hotel.stars){
                            Image(
                                painter = painterResource(id = R.drawable.star_outline),
                                contentDescription = "star",
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }
                    Text(text = hotel.location)
                }
                Image(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = "location",
                    modifier = Modifier.size(40.dp)
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CardPreview() {

    //HotelCard(Hotel("hotel", R.drawable.img, 4, "location"))

}