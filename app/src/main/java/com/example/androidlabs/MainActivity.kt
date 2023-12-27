package com.example.androidlabs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.androidlabs.DB.models.User
import com.example.androidlabs.composeui.Navigation.Navigate
import com.example.androidlabs.composeui.hotelScreen.HotelInfo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigate()
        }
    }
}
class GlobalUser private constructor() {
    private var user: User? = null

    fun setUser(user: User?) {
        this.user = user
    }

    fun getUser(): User? {
        return user
    }

    companion object {
        private var instance: GlobalUser? = null

        fun getInstance(): GlobalUser {
            return instance ?: synchronized(this) {
                instance ?: GlobalUser().also { instance = it }
            }
        }
    }
}




