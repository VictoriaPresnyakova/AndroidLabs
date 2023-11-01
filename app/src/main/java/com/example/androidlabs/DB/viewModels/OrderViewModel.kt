package com.example.androidlabs.DB.viewModels

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
import com.example.androidlabs.GlobalUser
import kotlinx.coroutines.launch
import java.util.Date

class OrderViewModel(val database: AppDatabase) : ViewModel() {
    var selectedItem: Hotel? = null
    val rooms = mutableStateOf("")

    fun deleteOrder(order: Order) = viewModelScope.launch {
        database.orderDao().delete(order)
    }

    fun getOrderList(id: Int) = viewModelScope.launch {
        database.userDao().getUserOrders(id)
    }


    fun createOrder() = viewModelScope.launch {
        Log.d("MyLog", GlobalUser.getInstance().getUser()?.userId.toString())

        val order = Order(
            dateFrom = Date().time,
            dateTo = Date().time,
            rooms = rooms.value.toInt(),
            total = getSubTotal(),
            bookedHotelId = selectedItem?.hotelId!!,
            creatorUserId = GlobalUser.getInstance().getUser()?.userId!!,
            hotel = selectedItem!!
        )

        val orderId = database.orderDao().createOrder(order)


        rooms.value = ""
        selectedItem = null
    }

    fun getSubTotal(): Double {
        return selectedItem!!.price * rooms.value.toInt()
    }

    companion object{
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory{
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val database = (checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]) as App).database
                return OrderViewModel(database) as T
            }
        }
    }
}
