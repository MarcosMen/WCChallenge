package com.example.webcontrolchallenge.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity (
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "avatar")
    val avatar: String?,
    @ColumnInfo(name = "creation_at")
    val creationAt: String?,
    @ColumnInfo(name = "email")
    val email: String?,
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "password")
    val password: String?,
    @ColumnInfo(name = "role")
    val role: String?,
    @ColumnInfo(name = "updated_at")
    val updatedAt: String?
)