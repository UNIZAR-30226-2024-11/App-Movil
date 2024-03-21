package com.example.unograham.io

import android.telecom.Call
import com.example.unograham.io.reponse.LoginResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST(value = "login") // Petición a la ruta del login
    fun postlogin(@Query(value="user")user:String, @Query(value="contraseña")contraseña: String):
            Call<LoginResponse>
    companion object Factory{
        private const val BASE_URL = "" //URL de la aplicación
        fun create(): ApiService{
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }

}