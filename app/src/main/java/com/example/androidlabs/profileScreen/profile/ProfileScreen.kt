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
import com.example.androidlabs.R

@Composable
fun ProfileScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
    ){
        Row(
        ){
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = (colorResource(id = R.color.figma_blue)),
                    contentColor = Color.White
                ),
                onClick = {
                    navController.navigate("person")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)
                    .height(50.dp)
            ) {
                Text(text = "Profile")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
        ){
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = (colorResource(id = R.color.figma_blue)),
                    contentColor = Color.White
                ),
                onClick = {
                    navController.navigate("login")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)
                    .height(50.dp)
            ) {
                Text(text = "Sign In")
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
        ){
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = (colorResource(id = R.color.figma_blue)),
                    contentColor = Color.White
                ),
                onClick = {
                    navController.navigate("signup")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp, 16.dp, 0.dp)
                    .height(50.dp)
            ) {
                Text(text = "Sign Up")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProfileScreenPreview(){
    val navController = rememberNavController()
    ProfileScreen(navController = navController)
}