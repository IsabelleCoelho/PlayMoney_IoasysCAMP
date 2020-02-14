package br.com.ioasys.camp.playmoney

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class UserForgotPassword(
    @SerializedName("email")
    val email: String
): Serializable