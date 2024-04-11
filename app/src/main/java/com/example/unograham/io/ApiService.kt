package com.example.unograham.io

import retrofit2.Call
import com.example.unograham.io.reponse.LoginResponse
import com.example.unograham.io.response.RegisterResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST(value = "login") // Petición a la ruta del login
    fun postlogin(@Query(value="user")user:String, @Query(value="contraseña")contrasena: String):
            Call<LoginResponse>
    @POST(value = "register") // Petición a la ruta del registro
    fun postRegister(@Query(value="user") user: String, @Query("email") email: String, @Query(value="contraseña") contraseña: String):
            Call<RegisterResponse>

    companion object Factory{
        private const val BASE_URL = "https://backend-eg2q.onrender.com/api/" //URL de la API
        fun create(): ApiService{
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}