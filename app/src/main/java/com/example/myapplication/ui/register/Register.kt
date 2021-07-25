package com.example.myapplication.ui.register

import com.google.gson.annotations.SerializedName

data class Response(

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("user")
	val user: User? = null
)

data class User(

	@field:SerializedName("email")
	val email: String? = null
)
