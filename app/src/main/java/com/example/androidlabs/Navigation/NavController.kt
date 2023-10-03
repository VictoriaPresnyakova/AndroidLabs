package com.example.androidlabs.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.androidlabs.homeScreen.HomeScreen
import com.example.androidlabs.profileScreen.profile.ProfileScreen
import com.example.androidlabs.profileScreen.signIn.LoginScreen


@Composable
fun NavController(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = NavItem.Home.route
    ){
        composable(NavItem.Home.route){
            HomeScreen()
        }
//        composable(NavItem.Like.route){
//            LikeScreen()
//        }
        composable(NavItem.Profile.route) {
            ProfileScreen(navController)
        }
        composable(NavItem.SignIn.route){
            LoginScreen(navController)
        }
        }
    }
