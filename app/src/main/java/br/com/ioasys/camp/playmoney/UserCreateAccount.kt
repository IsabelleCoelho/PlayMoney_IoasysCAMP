package br.com.ioasys.camp.playmoney

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class UserCreateAccount(
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("birthday")
    val birthday: String,
    @SerializedName("gender")
    val gender: String,
    @SerializedName("password")
    val password: String
): Serializable