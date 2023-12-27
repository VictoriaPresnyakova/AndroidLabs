package com.example.androidlabs.businessLogic.viewModels

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
import com.example.androidlabs.businessLogic.repository.UserRepository
import com.example.androidlabs.GlobalUser
import com.example.androidlabs.R
import com.example.androidlabs.api.model.UserRemoteSignIn

import kotlinx.coroutines.launch

class UserViewModel(private val userRepository: UserRepository): MyViewModel() {

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
            photo = R.drawable.img_1
        )
        runInScope(
            actionSuccess = {
                userRepository.createUser(user)
            }
        )
    }

    fun authUser() {
        if(email.value != "" && password.value != ""){
            runInScope(
                actionSuccess = {
                    val user = userRepository.authUser(UserRemoteSignIn(email.value, password.value))
                    GlobalUser.getInstance().setUser(user)
                },
                actionError = {
                    GlobalUser.getInstance().setUser(null)
                }
            )
        }
    }

    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}