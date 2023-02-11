package com.example.webcontrolchallenge.data

import com.example.webcontrolchallenge.model.UserDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface APIPlatzi {
    @GET("users")
    suspend fun getQuotes() : Response<List<UserDTO>>
}