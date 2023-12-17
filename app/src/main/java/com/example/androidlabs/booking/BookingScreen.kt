package com.example.androidlabs.booking

import android.widget.DatePicker
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.androidlabs.DB.models.Hotel
import com.example.androidlabs.DB.viewModels.OrderViewModel
import com.example.androidlabs.GlobalUser
import com.example.androidlabs.R
import android.app.DatePickerDialog
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidlabs.DB.viewModels.AppViewModelProvider
import java.util.Calendar
import java.util.Date

@Composable
fun BookingScreen(hotel: Hotel, navHostController: NavHostController, orderViewModel: OrderViewModel = viewModel(factory = AppViewModelProvider.Factory)) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Booking",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(16.dp)
        )

        TextField(
            value = orderViewModel.rooms.value,
            onValueChange = { orderViewModel.rooms.value = it},
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
                    text = "Rooms",
                    style = TextStyle(fontSize = 12.sp)
                )
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

// Fetching the Local Context
        val mContext = LocalContext.current

        // Declaring integer values
        // for year, month and day
        val mYearFrom: Int
        val mMonthFrom: Int
        val mDayFrom: Int

        // Initializing a Calendar
        val mCalendarFrom = Calendar.getInstance()

        // Fetching current year, month and day
        mYearFrom = mCalendarFrom.get(Calendar.YEAR)
        mMonthFrom = mCalendarFrom.get(Calendar.MONTH)
        mDayFrom = mCalendarFrom.get(Calendar.DAY_OF_MONTH)

        mCalendarFrom.time = Date()

        // Declaring a string value to
        // store date in string format
        val mDateFrom = remember { mutableStateOf("") }

        // Declaring DatePickerDialog and setting
        // initial values as current values (present year, month and day)
        val mDatePickerDialogFrom = DatePickerDialog(
            mContext,
            { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
                mDateFrom.value = "$mDayOfMonth/${mMonth+1}/$mYear"
            }, mYearFrom, mMonthFrom, mDayFrom
        )


            // Creating a button that on
            // click displays/shows the DatePickerDialog
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = (colorResource(id = R.color.figma_blue)),
                contentColor = Color.White
            ),
            onClick = {
                mDatePickerDialogFrom.show()

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 16.dp, 16.dp, 0.dp)
                .height(50.dp)
        ) {
            Text("Open Date Picker")
        }



        // Displaying the mDate value in the Text
            Text(text = "Selected Date From: ${mDateFrom.value}", fontSize = 15.sp)


        Spacer(modifier = Modifier.height(16.dp))


// Fetching the Local Context

        // Declaring integer values
        // for year, month and day
        val mYear: Int
        val mMonth: Int
        val mDay: Int

        // Initializing a Calendar
        val mCalendar = Calendar.getInstance()

        // Fetching current year, month and day
        mYear = mCalendar.get(Calendar.YEAR)
        mMonth = mCalendar.get(Calendar.MONTH)
        mDay = mCalendar.get(Calendar.DAY_OF_MONTH)

        mCalendar.time = Date()

        // Declaring a string value to
        // store date in string format
        val mDate = remember { mutableStateOf("") }

        // Declaring DatePickerDialog and setting
        // initial values as current values (present year, month and day)
        val mDatePickerDialog = DatePickerDialog(
            mContext,
            { _: DatePicker, mYear: Int, mMonth: Int, mDayOfMonth: Int ->
                mDate.value = "$mDayOfMonth/${mMonth+1}/$mYear"
            }, mYear, mMonth, mDay
        )


            // Creating a button that on
            // click displays/shows the DatePickerDialog

        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = (colorResource(id = R.color.figma_blue)),
                contentColor = Color.White
            ),
            onClick = {
                mDatePickerDialog.show()

            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 16.dp, 16.dp, 0.dp)
                .height(50.dp)
        ) {
            Text("Open Date Picker")
        }

            // Displaying the mDate value in the Text
            Text(text = "Selected Date To: ${mDate.value}", fontSize = 15.sp,)


        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = (colorResource(id = R.color.figma_blue)),
                contentColor = Color.White
            ),
            onClick = {
                if(GlobalUser.getInstance().getUser() != null){
                    orderViewModel.selectedItem = hotel
                    orderViewModel.dateFrom = mDateFrom
                    orderViewModel.dateTo = mDate
                    orderViewModel.createOrder()
                    navHostController.navigate("home")
                }else{
                    navHostController.navigate("login")
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, 16.dp, 16.dp, 0.dp)
                .height(50.dp)
        ) {
            Text("Book")
        }
        }
    }

//@Composable
//@Preview(showBackground = true)
//fun BookingScreenPreview(){
//    val navController = rememberNavController()
//    BookingScreen()
//}