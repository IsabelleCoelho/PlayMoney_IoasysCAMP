package br.com.ioasys.camp.playmoney

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserService
{
    @POST("login")
    fun login(@Body user: UserLogin): Call<UserLogin>

    @POST("forgotpassword")
    fun forgotPassword(@Body user: UserForgotPassword): Call<UserForgotPassword>

    @POST("newuser")
    fun createAccount(@Body user: UserCreateAccount): Call<UserCreateAccount>
/*
    @GET("users")
    fun listUsers(): Call<ArrayList<User>>*/
}