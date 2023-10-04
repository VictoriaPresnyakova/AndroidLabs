package com.example.androidlabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.androidlabs.Navigation.Navigate
import com.example.androidlabs.hotelScreen.HotelInfo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setContent {
                Navigate()
                //HotelInfo(Hotel("hotel", R.drawable.img_1, 4, "location"))
            }
        }
    }




