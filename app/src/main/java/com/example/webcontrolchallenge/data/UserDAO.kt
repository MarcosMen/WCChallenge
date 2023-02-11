package com.example.webcontrolchallenge.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDAO {
    @Query ("select * from user")
    fun getAll(): List<UserEntity>

    @Insert
    fun insertAll(vararg list: UserEntity)

    @Insert
    fun insert( user: UserEntity):Long

}