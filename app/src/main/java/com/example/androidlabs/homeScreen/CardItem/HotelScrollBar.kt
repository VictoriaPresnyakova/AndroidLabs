package com.example.androidlabs.homeScreen.CardItem

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androidlabs.R

@Composable
fun HotelScrollBar() {
    Column {
        Card(Hotel("hotel", R.drawable.img, 5, "location"))
        Card(Hotel("hotel", R.drawable.img, 5, "location"))
        Card(Hotel("hotel", R.drawable.img, 5, "location"))
        Card(Hotel("hotel", R.drawable.img, 5, "location"))
        Card(Hotel("hotel", R.drawable.img, 5, "location"))
        Card(Hotel("hotel", R.drawable.img, 5, "location"))
        Card(Hotel("hotel", R.drawable.img, 5, "location"))
        Card(Hotel("hotel", R.drawable.img, 5, "location"))

    }
}
@Preview(showBackground = true)
@Composable
fun HotelPreview() {
    HotelScrollBar()
}