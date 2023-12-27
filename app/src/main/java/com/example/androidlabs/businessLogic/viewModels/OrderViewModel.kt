package com.example.androidlabs.businessLogic.viewModels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.androidlabs.App
import com.example.androidlabs.DB.AppDatabase
import com.example.androidlabs.DB.models.Hotel
import com.example.androidlabs.DB.models.Order
import com.example.androidlabs.DB.models.UserWithOrder
import com.example.androidlabs.businessLogic.repository.OrderRepository
import com.example.androidlabs.GlobalUser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.util.Date

class OrderViewModel(private val orderRepository: OrderRepository) : ViewModel() {
    var selectedItem: Hotel? = null
    val rooms = mutableStateOf("")
    var dateFrom = mutableStateOf("")
    var dateTo = mutableStateOf("")

    fun deleteOrder(orderId: Int) = viewModelScope.launch {
        orderRepository.delete(orderId)
    }

    suspend fun getOrderList(id: Int) : Flow<List<Order>> {
        return orderRepository.getUserOrders(id)
    }

    suspend fun getHotelFromOrder(id: Int) : Hotel {
        return orderRepository.getHotelFromOrder(id)
    }

    fun createOrder() = viewModelScope.launch {
        Log.d("MyLog", GlobalUser.getInstance().getUser()?.userId.toString())

        val order = Order(
            dateFrom = dateFrom.value,
            dateTo = dateTo.value,
            rooms = rooms.value.toInt(),
            total = getSubTotal(),
            bookedHotelId = selectedItem?.hotelId!!,
            creatorUserId = GlobalUser.getInstance().getUser()?.userId!!,
            //hotel = selectedItem!!
        )

        val orderId = orderRepository.createOrder(order)


        rooms.value = ""
        selectedItem = null
    }

    fun getSubTotal(): Double {
        return selectedItem!!.price * rooms.value.toInt()
    }
}
