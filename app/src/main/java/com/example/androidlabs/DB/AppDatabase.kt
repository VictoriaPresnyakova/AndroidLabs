package com.example.androidlabs.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.androidlabs.DB.dao.HotelDao
import com.example.androidlabs.DB.dao.OrderDao
import com.example.androidlabs.DB.dao.RemoteKeysDao
import com.example.androidlabs.DB.dao.UserDao
import com.example.androidlabs.DB.models.Hotel
import com.example.androidlabs.DB.models.Order
import com.example.androidlabs.DB.models.RemoteKeys
import com.example.androidlabs.DB.models.RoleEnum
import com.example.androidlabs.DB.models.User
import com.example.androidlabs.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
// TODO
@Database(entities = [Hotel::class, User::class, Order::class, RemoteKeys::class], version = 5)
abstract class AppDatabase : RoomDatabase() {
    abstract fun hotelDao(): HotelDao
    abstract fun userDao(): UserDao
    abstract fun orderDao(): OrderDao
    abstract fun remoteKeysDao(): RemoteKeysDao


    companion object {
        private const val DB_NAME: String = "my-db"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        suspend fun populateDatabase() {
            INSTANCE?.let { database ->
                // User
                val userDao = database.userDao()
                val user1 = User(null, "Artem", "Emelyanov", "artem@mail.ru", "123", "USER")
                val user2 = User(null, "Danil", "Markov", "danil@mail.ru", "123", "ADMIN")
                val user3 = User(null, "Viktoria", "Presnyakova", "vika@mail.ru", "123", "USER")
                userDao.createUser(user1)
                userDao.createUser(user2)
                userDao.createUser(user3)
                // Sneaker
                val hotelDao = database.hotelDao()
                val hotel1 = Hotel(null, "Hotel1", 1000.0, R.drawable.img, 1, "location1", "info1")
                val hotel2 = Hotel(null, "Hotel2", 2000.0, R.drawable.img_2, 2, "location2", "info2")
                val hotel3 = Hotel(null, "Hotel3", 3000.0, R.drawable.img_3, 3, "location3", "info3")
                val hotel4 = Hotel(null, "Hotel4", 4000.0, R.drawable.img_4, 4, "location4", "info4")
                hotelDao.insert(hotel1)
                hotelDao.insert(hotel2)
                hotelDao.insert(hotel3)
                hotelDao.insert(hotel4)
                // Order
            }
        }

        fun getInstance(appContext: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    appContext,
                    AppDatabase::class.java,
                    DB_NAME
                )
                    .addCallback(object : Callback() {
                        override fun onCreate(db: SupportSQLiteDatabase) {
                            super.onCreate(db)
                            CoroutineScope(Dispatchers.IO).launch {
                                populateDatabase()
                            }
                        }
                    })
                    .fallbackToDestructiveMigration()
                    .build()
                    .also { INSTANCE = it }
            }
        }
    }
}