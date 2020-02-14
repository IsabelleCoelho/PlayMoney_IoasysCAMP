package br.com.ioasys.camp.playmoney

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class UserLogin(
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
): Serializable