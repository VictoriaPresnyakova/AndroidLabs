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
import com.example.androidlabs.GlobalUser

import kotlinx.coroutines.launch
class UserViewModel(val database: AppDatabase): ViewModel() {

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
            role = RoleEnum.User
        )
        database.userDao().createUser(user)
    }
    fun authUser() = viewModelScope.launch {
        val user = database.userDao().getUserByEmail(email.value)
        if (password.value != "" && user.password == password.value) {
            val globalUser = GlobalUser.getInstance()
            globalUser.setUser(user)
            Log.d("MyLog", GlobalUser.getInstance().getUser()?.userId.toString())
            println()

        }
    }
    fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    companion object{
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory{
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val database = (checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]) as App).database
                return UserViewModel(database) as T
            }
        }
    }
}