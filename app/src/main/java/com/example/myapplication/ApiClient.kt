package com.example.myapplication

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    fun getClient(): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
                    .baseUrl("http://gelangcovidpintar.com/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build()

        }
}