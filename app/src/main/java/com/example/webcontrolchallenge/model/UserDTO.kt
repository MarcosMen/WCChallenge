package com.example.webcontrolchallenge.model

data class UserDTO(
    val id: Int,
    val avatar: String?="",
    val creationAt: String?="",
    val email: String?="",
    val name: String?="",
    val password: String?="",
    val role: String?="",
    val updatedAt: String?=""
)