package com.example.androidlabs.composeui.profileScreen.signUp

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androidlabs.businessLogic.viewModels.AppViewModelProvider
import com.example.androidlabs.businessLogic.viewModels.UserViewModel
import com.example.androidlabs.R
import com.example.androidlabs.api.ApiStatus
import com.example.androidlabs.composeui.profileScreen.circular
import com.example.androidlabs.composeui.profileScreen.signIn.LoginScreen

@Composable
fun SignUpCard(navHostController: NavHostController, userViewModel: UserViewModel = viewModel(factory = AppViewModelProvider.Factory)) {
    val context = LocalContext.current
    when(userViewModel.apiStatus){
        ApiStatus.LOADING -> circular()
        ApiStatus.ERROR -> Toast.makeText(context, "Не удалось создать пользователя: " + userViewModel.apiError, Toast.LENGTH_SHORT).show()
        else -> {}
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
    ){
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            Text(
                text = "Sign Up",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(16.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = userViewModel.name.value,
                onValueChange = { userViewModel.name.value = it },
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
                        text = "Name",
                        style = TextStyle(fontSize = 12.sp)
                    )
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = userViewModel.surname.value,
                onValueChange = { userViewModel.surname.value = it },
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
                        text = "Surname",
                        style = TextStyle(fontSize = 12.sp)
                    )
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = userViewModel.email.value,
                onValueChange = { userViewModel.email.value = it },
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
                        text = "Email",
                        style = TextStyle(fontSize = 12.sp)
                    )
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = userViewModel.password.value,
                onValueChange = { userViewModel.password.value = it },
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
                        text = "Password",
                        style = TextStyle(fontSize = 12.sp)
                    )
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = (colorResource(id = R.color.figma_blue)),
                    contentColor = Color.White
                ),
                onClick = {
                    userViewModel.createUser()
                    navHostController.navigate("login")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 16.dp, 16.dp, 0.dp)
                    .height(50.dp)
            ) {
                Text("Sign Up")
            }
        }
    }
}

