package com.example.androidlabs.homeScreen.CardItem

import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidlabs.R
import com.example.androidlabs.ui.theme.AndroidLabsTheme

@Composable
fun Card (hotel: Hotel){
    androidx.compose.material3.Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 20.dp
        )    ) {
        Box(
            //modifier = Modifier.background(Color.Green)
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
                        Image(
                            imageVector = Icons.Filled.Star,
                            contentDescription = "location",
                            modifier = Modifier.size(20.dp)
                        )
                        Image(
                            imageVector = Icons.Filled.Star,
                            contentDescription = "location",
                            modifier = Modifier.size(20.dp)
                        )
                        Image(
                            imageVector = Icons.Filled.Star,
                            contentDescription = "location",
                            modifier = Modifier.size(20.dp)
                        )
                        Image(
                            imageVector = Icons.Filled.Star,
                            contentDescription = "location",
                            modifier = Modifier.size(20.dp)
                        )
                        Image(
                            imageVector = Icons.Filled.Star,
                            contentDescription = "location",
                            modifier = Modifier.size(20.dp)
                        )
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

    Card(Hotel("hotel", R.drawable.img, 5, "location"))

}