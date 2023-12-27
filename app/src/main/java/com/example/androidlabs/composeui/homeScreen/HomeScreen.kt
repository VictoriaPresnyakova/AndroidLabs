package com.example.androidlabs.composeui.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemKey
import com.example.androidlabs.DB.models.Hotel
import com.example.androidlabs.businessLogic.viewModels.AppViewModelProvider
import com.example.androidlabs.businessLogic.viewModels.HotelViewModel
import com.example.androidlabs.R
import com.example.androidlabs.composeui.homeScreen.CardItem.HotelCard
import com.example.androidlabs.composeui.homeScreen.SearchField.SearchField

@Composable
fun HomeScreen(navController: NavHostController, hotelViewModel: HotelViewModel = viewModel(factory = AppViewModelProvider.Factory)) {
    val list = hotelViewModel.hotelList.collectAsState().value.collectAsLazyPagingItems()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            //.padding(bottom = 60.dp)
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
                    hotelViewModel.searchHotelsByFilter(searchText)
                }
            }
        }
        Column (
            modifier = Modifier
                //.verticalScroll(rememberScrollState())
            .padding(bottom = 60.dp)

        ){
            LazyVerticalGrid(
                columns = GridCells.Fixed(1)
            ) {
                items(
                    count = list.itemCount,
                    key = list.itemKey { hotel -> hotel.hotelId!! }
                ) { index: Int ->
                    val hotel: Hotel? = list[index]
                    if (hotel != null) {
                        HotelCard(hotel, navController)
                    }
                }
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