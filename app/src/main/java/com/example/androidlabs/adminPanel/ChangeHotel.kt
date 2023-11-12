package com.example.androidlabs.adminPanel

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androidlabs.DB.models.Hotel
import com.example.androidlabs.DB.viewModels.HotelViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidlabs.DB.models.PhotoManager
import com.example.androidlabs.DB.viewModels.AppViewModelProvider
import com.example.androidlabs.R

@Composable
fun ChangeHotel(hotel: Hotel, onBackClick: () -> Unit, hotelViewModel: HotelViewModel = viewModel(factory = AppViewModelProvider.Factory)) {
    val name = remember { mutableStateOf(hotel.name) }
    val price = remember{ mutableStateOf(hotel.price.toString()) }
    val stars = remember{ mutableStateOf(hotel.stars.toString()) }
    val location = remember{ mutableStateOf(hotel.location) }
    val info = remember{ mutableStateOf(hotel.info) }
    var img by remember { mutableStateOf(hotel.img) }
    val photoManager = PhotoManager()
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(16.dp))
            .verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = "image",
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(200.dp)
            )
            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.figma_blue),
                    contentColor = Color.White
                ),
                onClick = {
                    img = photoManager.changePhoto(img)

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 0.dp, 16.dp, 16.dp)
                    .height(50.dp)
            ) {
                Text("Change image")
            }
            TextField(
                value = name.value,
                onValueChange = { newValue -> name.value = newValue },
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
                value = stars.value,
                onValueChange = { stars.value = it },
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
                        text = "Stars",
                        style = TextStyle(fontSize = 12.sp)
                    )
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = location.value,
                onValueChange = { location.value = it },
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
                        text = "Location",
                        style = TextStyle(fontSize = 12.sp)
                    )
                }
            )

            Spacer(modifier = Modifier.height(16.dp))



            TextField(
                value = price.value,
                onValueChange = { price.value = it },
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
                        text = "Price",
                        style = TextStyle(fontSize = 12.sp)
                    )
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = info.value,
                onValueChange = { info.value = it },
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
                        text = "Info",
                        style = TextStyle(fontSize = 12.sp)
                    )
                }
            )

            Button(
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = colorResource(id = R.color.figma_blue),
                    contentColor = Color.White
                ),
                onClick = {
                    hotelViewModel.UpdateHotel(
                        Hotel(
                            hotelId = hotel.hotelId,
                            name = name.value,
                            price = price.value.toDouble(),
                            img = img,
                            stars = stars.value.toInt(),
                            location = location.value,
                            info = info.value
                        )
                    )
                    onBackClick()
                          },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .height(50.dp)
            ) {
                Text("Change hotel")
            }
        }
    }
}