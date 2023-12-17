package com.example.androidlabs.MyOrderScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.androidlabs.DB.models.Order
import com.example.androidlabs.DB.viewModels.OrderViewModel
import com.example.androidlabs.GlobalUser
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidlabs.DB.viewModels.AppViewModelProvider
import kotlinx.coroutines.flow.first




@Composable
fun MyOrderScreen(orderViewModel: OrderViewModel= viewModel(factory = AppViewModelProvider.Factory)) {
//    val userWithOrder by orderViewModel.database.userDao().getUserOrders(GlobalUser.getInstance().getUser()?.userId!!).collectAsState(null)
    val userId = GlobalUser.getInstance().getUser()?.userId
    var usersOrder by remember { mutableStateOf<List<Order>>(emptyList()) }
    LaunchedEffect(userId) {
        usersOrder = orderViewModel.getOrderList(userId!!).first()
    }
    Column(
        modifier = Modifier
            .padding(bottom = 50.dp)
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState())

    ){
        Text(
            text = "My order",
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(10.dp, 10.dp)
        )
        Row {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                if (usersOrder != null) {
                    for (item in usersOrder) {
                        OrderCard(item)
                    }
                }
            }
        }
    }
}