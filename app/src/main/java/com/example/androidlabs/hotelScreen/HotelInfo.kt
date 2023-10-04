package com.example.androidlabs.hotelScreen

import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.androidlabs.Hotel
import com.example.androidlabs.R
import com.example.androidlabs.homeScreen.CardItem.HotelCard

@Composable
fun HotelInfo(hotel: Hotel, navController: NavHostController) {
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
                Text(text = "Rs. 4000")
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
                Text(text = "inf")
            }
        }
        //Divider(color = Color.Black, thickness = 1.dp)
        Row(
            modifier = Modifier
                //.fillMaxHeight()
                .padding(horizontal = 60.dp)
                .padding(bottom = 60.dp),
            verticalAlignment = Alignment.Bottom
        ){
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = (Color(red = 0x2A, green = 0x7D, blue = 0xB9, alpha = 0xFF)),
                    contentColor = Color.White
                ),
                onClick = {
                    navController.navigate("booking")
                },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text("Select Room")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HotelInfoPreview() {

    //HotelInfo(Hotel("hotel", R.drawable.img_1, 4, "location"))

}