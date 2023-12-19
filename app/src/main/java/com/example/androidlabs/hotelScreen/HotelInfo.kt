package com.example.androidlabs.hotelScreen

import android.util.Log
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonColors
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androidlabs.DB.models.Hotel
import com.example.androidlabs.R
import com.example.androidlabs.homeScreen.CardItem.HotelCard
import com.google.gson.Gson

@Composable
fun HotelInfo(hotel: Hotel, navController: NavHostController) {
    Log.d("MyLog", hotel.toString())

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.White)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween,

    ){

            Image(
                painter = painterResource(id = hotel.img),
                contentDescription = "hotel",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier
                    .fillMaxWidth()
            )
        Box(
            modifier = Modifier.background(Color.White)
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth(),

                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Text(text = hotel.name)
                // stars
            }
        }
        Divider(color = Color.Black, thickness = 1.dp)
        Box(
            modifier = Modifier.background(Color.White)
        ){
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Text(text = "1 room | 1 Night")
                Text(text = "Rs. " + hotel.price)
            }
        }
        Divider(color = Color.Black, thickness = 1.dp)
        Box(
            modifier = Modifier
                .background(Color.White)
        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    ,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ){
                Text(text = "Location")
                Text(text = hotel.location)
            }
        }
        Divider(color = Color.Black, thickness = 1.dp)
        Box(
            modifier = Modifier
                .background(Color.White)
        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ){
                Text(text = "Amenties")
                Text(text = "wifi")
            }
        }
        Divider(color = Color.Black, thickness = 1.dp)

        Box(
            modifier = Modifier
                .background(Color.White)
        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                ,
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ){
                Text(text = "Info")
                Text(text = hotel.info)
            }
        }
        Row(
           modifier = Modifier
                .padding(bottom = 60.dp),
            verticalAlignment = Alignment.Bottom
        ){
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = (colorResource(id = R.color.figma_blue)),
                    contentColor = Color.White
                ),
                onClick = {
                    val hotelItemString = Gson().toJson(hotel)
                    navController.navigate("booking/${hotelItemString}")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 16.dp, 16.dp, 5.dp)
                    .height(50.dp)
            ) {
                Text("Select Room")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HotelInfoPreview() {
    val navController = rememberNavController()
   // HotelInfo(Hotel("hotel", R.drawable.img_1, 4, "location", "info", 4000), navController)

}