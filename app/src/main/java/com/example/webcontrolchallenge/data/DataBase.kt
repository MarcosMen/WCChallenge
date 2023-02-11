package com.example.webcontrolchallenge.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version=1)
abstract class DataBaseWC:RoomDatabase() {
    abstract fun userDao(): UserDAO
}
