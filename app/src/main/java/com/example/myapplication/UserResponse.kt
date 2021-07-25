package com.example.myapplication

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.*

class UserResponse {
    @SerializedName("data")
    @Expose
    var data: User? = null

    class User{
        @SerializedName("firstname")
        @Expose
        var firstname: String? = null

        @SerializedName("lastname")
        @Expose
        var lastname: String? = null

        @SerializedName("email")
        @Expose
        var email: String? = null

        @SerializedName("pass")
        @Expose
        var password: String? = null

        @SerializedName("dateofbirth")
        @Expose
        var dateofbirth: Date? = null
    }
}