package br.com.ioasys.camp.playmoney

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.25.145:3333/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun userService() : UserService{
        return retrofit.create(UserService::class.java)
    }
}