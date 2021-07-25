package com.example.myapplication.ui

import com.example.myapplication.UserRequest
import com.example.myapplication.UserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface UserApi {
    @FormUrlEncoded
    @POST("login.php")
    fun loginresponse(
        @Body userRequest: UserRequest
    ): Call<UserResponse>
}

