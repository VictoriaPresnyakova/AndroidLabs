package com.example.androidlabs.profileScreen.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable;
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import com.example.androidlabs.GlobalUser
import com.example.androidlabs.R
import com.example.androidlabs.profileScreen.signIn.LoginScreen

@Composable
fun ProfileScreen(navController: NavHostController) {
    val globalUser: GlobalUser = GlobalUser.getInstance()
    if(globalUser.getUser() != null){
        Person(navController)
    }else{
        LoginScreen(navController = navController)
    }
}

@Composable
@Preview
fun ProfileScreenPreview(){
    val navController = rememberNavController()
    ProfileScreen(navController = navController)
}