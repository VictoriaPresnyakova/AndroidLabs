package com.example.androidlabs.Navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class NavItem(val route: String, val icon: ImageVector?){
    object Home : NavItem("home", Icons.Default.Home)
    object Profile : NavItem("profile", Icons.Default.Person)
    object SignIn : NavItem("login", null)
    object HotelInfo : NavItem("HotelInfo", null)
    object Booking : NavItem("booking", null)

}