package com.example.webcontrolchallenge.utils

import com.example.webcontrolchallenge.data.UserEntity
import com.example.webcontrolchallenge.model.UserDTO

fun UserDTO.toUserEntity() = UserEntity(id,avatar, creationAt, email, name, password, role, updatedAt)

fun UserEntity.toUserDTO() = UserDTO(id,avatar, creationAt, email, name, password, role, updatedAt)