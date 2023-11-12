package com.example.androidlabs.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidlabs.DB.models.Hotel
import com.example.androidlabs.DB.viewModels.AppViewModelProvider
import com.example.androidlabs.DB.viewModels.OrderViewModel
import com.example.androidlabs.MyOrderScreen.MyOrderScreen
import com.example.androidlabs.booking.BookingScreen
import com.example.androidlabs.homeScreen.HomeScreen
import com.example.androidlabs.hotelScreen.HotelInfo
import com.example.androidlabs.profileScreen.profile.Person
import com.example.androidlabs.profileScreen.profile.ProfileScreen
import com.example.androidlabs.profileScreen.signIn.LoginScreen
import com.example.androidlabs.profileScreen.signUp.SignUpScreen
import com.example.androidlabs.adminPanel.AddPanel
import com.example.androidlabs.adminPanel.AdminPanel
import com.example.androidlabs.adminPanel.ChangeHotel
import com.example.androidlabs.adminPanel.ChangePanel
import com.google.gson.Gson

@Composable
fun NavController(navController: NavHostController) {
    var orderViewModel: OrderViewModel = viewModel(factory = AppViewModelProvider.Factory)
    NavHost(
        navController = navController,
        startDestination = NavItem.Home.route
    ) {
        composable(NavItem.HotelInfo.route) {
            //
            backStackEntry ->
            val hotelItemString = backStackEntry.arguments?.getString("hotelItem")
            val hotelItem = Gson().fromJson(hotelItemString, Hotel::class.java)
            hotelItem?.let { HotelInfo(it, navController)
            }
        }
        composable(NavItem.Home.route) {
            HomeScreen(navController)
        }
        composable(NavItem.MyOrder.route){
            MyOrderScreen(orderViewModel)
        }
        composable(NavItem.Profile.route) {
            ProfileScreen(navController)
        }
        composable(NavItem.SignIn.route){
            LoginScreen(navController)
        }
        composable(NavItem.SignUp.route){
            SignUpScreen(navController)
        }
        composable(NavItem.Booking.route) {
            backStackEntry ->
            val hotelItemString = backStackEntry.arguments?.getString("hotelItem")
            val hotelItem = Gson().fromJson(hotelItemString, Hotel::class.java)
            hotelItem?.let { BookingScreen(orderViewModel, it, navController)
            }
        }
        composable(NavItem.ChangeHotel.route) { backStackEntry ->
            val hotelItemString = backStackEntry.arguments?.getString("hotelItem")
            val hotelItem = Gson().fromJson(hotelItemString, Hotel::class.java)
            hotelItem?.let { ChangeHotel(it, onBackClick = {
                navController.navigateUp() })
            }
        }
        composable(NavItem.Person.route) {
            Person(navController)
        }
        composable(NavItem.AdminPanel.route){
            AdminPanel(navController)
        }
        composable(NavItem.AddPanel.route){
            AddPanel(navController)
        }
        composable(NavItem.ChangePanel.route){
            ChangePanel(navController)
        }

    }
}