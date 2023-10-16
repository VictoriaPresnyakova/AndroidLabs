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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip

@Composable
fun ProfileScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
        ){
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = (Color(red = 0x2A, green = 0x7D, blue = 0xB9, alpha = 0xFF)),
                    contentColor = Color.White
                ),
                onClick = {
                    navController.navigate("person")
                },
                modifier = Modifier
                    .requiredSize(300.dp, 40.dp)
            ) {
                Text(text = "Profile")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
        ){
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = (Color(red = 0x2A, green = 0x7D, blue = 0xB9, alpha = 0xFF)),
                    contentColor = Color.White
                ),
                onClick = {
                    navController.navigate("login")
                },
                modifier = Modifier
                    .requiredSize(300.dp, 40.dp)
            ) {
                Text(text = "Sign In")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
        ){
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = (Color(red = 0x2A, green = 0x7D, blue = 0xB9, alpha = 0xFF)),
                    contentColor = Color.White
                ),
                onClick = {
                    navController.navigate("signup")
                },
                modifier = Modifier
                    .requiredSize(300.dp, 40.dp)
            ) {
                Text(text = "Sign Up")
            }
        }
    }
}

@Composable
@Preview
fun ProfileScreenPreview(){
    val navController = rememberNavController()
    ProfileScreen(navController = navController)
}