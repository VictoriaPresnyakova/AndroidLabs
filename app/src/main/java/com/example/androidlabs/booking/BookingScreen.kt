package com.example.androidlabs.booking

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.androidlabs.R
import com.example.androidlabs.profileScreen.signIn.LoginScreen

@Composable
fun BookingScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var room by remember { mutableStateOf("") }
        var date by remember { mutableStateOf("") }

        Text(
            text = "Booking",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp)
        )

        TextField(
            value = room,
            onValueChange = { room = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(16.dp, 0.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(4.dp)),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = {

                }
            ),
            placeholder = {
                Text(
                    text = "Room",
                    style = TextStyle(fontSize = 12.sp)
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = date,
            onValueChange = { date = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(16.dp, 0.dp)
                .border(1.dp, Color.Gray, RoundedCornerShape(4.dp)),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),

            keyboardActions = KeyboardActions(
                onNext = {

                }
            ),
            placeholder = {
                Text(
                    text = "Date",
                    style = TextStyle(fontSize = 12.sp)
                )
            }
        )

        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = (colorResource(id = R.color.figma_blue)),
                contentColor = Color.White
            ),
            onClick = {

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 16.dp, 16.dp, 0.dp)
                .height(50.dp)
        ) {
            Text("Payment")
        }
        }
    }

@Composable
@Preview(showBackground = true)
fun BookingScreenPreview(){
    val navController = rememberNavController()
    BookingScreen()
}