package com.example.androidlabs.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidlabs.Hotel
import com.example.androidlabs.R
import com.example.androidlabs.booking.BookingScreen
import com.example.androidlabs.homeScreen.CardItem.HotelCard
import com.example.androidlabs.homeScreen.HomeScreen
import com.example.androidlabs.hotelScreen.HotelInfo
import com.example.androidlabs.profileScreen.profile.ProfileScreen
import com.example.androidlabs.profileScreen.signIn.LoginScreen


@Composable
fun NavController(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = NavItem.Home.route
    ){
        composable(NavItem.HotelInfo.route){
            HotelInfo(Hotel("hotel", R.drawable.img_1, 4, "location"), navController)
        }
        composable(NavItem.Home.route){
            HomeScreen(navController)
        }
        composable(NavItem.Profile.route) {
            ProfileScreen(navController)
        }
        composable(NavItem.SignIn.route){
            LoginScreen(navController)
        }
        composable(NavItem.Booking.route){
            BookingScreen()
        }
        }
    }