package com.example.androidlabs.DB.viewModels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.androidlabs.App
import com.example.androidlabs.DB.AppDatabase
import com.example.androidlabs.DB.models.RoleEnum
import com.example.androidlabs.DB.models.User
import com.example.androidlabs.DB.repository.UserRepository
import com.example.androidlabs.GlobalUser
import com.example.androidlabs.R
import com.example.androidlabs.api.model.UserRemoteSignIn

import kotlinx.coroutines.launch
class UserViewModel(private val userRepository: UserRepository): ViewModel() {

    var name = mutableStateOf("")
    val surname = mutableStateOf("")
    val email = mutableStateOf("")
    val password = mutableStateOf("")
    fun createUser() = viewModelScope.launch {
        val user = User(
            name = name.value,
            surname = surname.value,
            email = email.value,
            password = password.value,
            role = "USER",
            photo = R.drawable.img_2
        )
        userRepository.createUser(user)
    }
    fun authUser() = viewModelScope.launch {
        val user = userRepository.authUser(UserRemoteSignIn(email.value, password.value))
        GlobalUser.getInstance().setUser(user)
    }

    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}