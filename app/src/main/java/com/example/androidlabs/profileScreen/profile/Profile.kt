package com.example.androidlabs.profileScreen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androidlabs.GlobalUser
import com.example.androidlabs.R

@Composable
fun Person(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                GlobalUser.getInstance().setUser(null)
                navHostController.navigate("profile")
            },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.white),
                contentColor = Color.Black
            ),
            modifier = Modifier
                .padding(16.dp, 0.dp)
        ) {
            Text("Exit")
        }
        ProfileCard(navHostController)
    }
}

@Preview
@Composable
fun PersonPreview(){
    val navController = rememberNavController()
    Person(navController)
}