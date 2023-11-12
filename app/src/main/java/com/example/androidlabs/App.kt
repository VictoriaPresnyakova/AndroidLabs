package com.example.androidlabs

import android.app.Application
import com.example.androidlabs.DB.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class App : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        //this.deleteDatabase("my-db")
        //CoroutineScope(Dispatchers.IO).launch {
          //  AppDatabase.populateDatabase()
        //}
        container = AppDataContainer(this)
    }
}