package com.example.androidlabs.composeui.Navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidlabs.DB.models.Hotel
import com.example.androidlabs.businessLogic.viewModels.AppViewModelProvider
import com.example.androidlabs.businessLogic.viewModels.OrderViewModel
import com.example.androidlabs.composeui.MyOrderScreen.MyOrderScreen
import com.example.androidlabs.composeui.booking.BookingScreen
import com.example.androidlabs.composeui.homeScreen.HomeScreen
import com.example.androidlabs.composeui.hotelScreen.HotelInfo
import com.example.androidlabs.composeui.profileScreen.profile.Person
import com.example.androidlabs.composeui.profileScreen.profile.ProfileScreen
import com.example.androidlabs.composeui.profileScreen.signIn.LoginScreen
import com.example.androidlabs.composeui.profileScreen.signUp.SignUpScreen
import com.example.androidlabs.composeui.adminPanel.AddPanel
import com.example.androidlabs.composeui.adminPanel.AdminPanel
import com.example.androidlabs.composeui.adminPanel.ChangeHotel
import com.example.androidlabs.composeui.adminPanel.ChangePanel
import com.google.gson.Gson

@Composable
fun NavController(navController: NavHostController) {
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
            MyOrderScreen()
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
            hotelItem?.let { BookingScreen(it, navController)
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