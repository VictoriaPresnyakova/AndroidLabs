package com.example.androidlabs.composeui.adminPanel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.androidlabs.businessLogic.viewModels.AppViewModelProvider
import com.example.androidlabs.businessLogic.viewModels.HotelViewModel


@Composable
fun ChangePanel(navHostController: NavHostController, hotelViewModel: HotelViewModel = viewModel(factory = AppViewModelProvider.Factory)){
    val list = hotelViewModel.hotelList.collectAsState().value.collectAsLazyPagingItems()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ){
        Row {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                items(list.itemCount) { index ->
                    list[index]?.let { hotel ->
                    CardHotelForChange(item = hotel, navHostController)
                }
            }
        }
    }
}
}