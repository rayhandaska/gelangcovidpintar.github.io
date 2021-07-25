package com.example.myapplication.ui.login

import com.google.gson.annotations.SerializedName

data class login(

	@field:SerializedName("error")
	val error: Boolean? = null,

	@field:SerializedName("user")
	val user: User? = null
)

data class User(

	@field:SerializedName("email")
	val email: Email? = null
)

data class Email(

	@field:SerializedName("dateofbirth")
	val dateofbirth: String? = null,

	@field:SerializedName("firstname")
	val firstname: String? = null,

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("email")
	val email: String? = null,

	@field:SerializedName("lastname")
	val lastname: String? = null
)
