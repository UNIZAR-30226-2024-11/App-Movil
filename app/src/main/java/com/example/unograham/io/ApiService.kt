package com.example.unograham.io

import com.example.unograham.model.Friend
import com.example.unograham.io.response.FriendRequestResponse
import retrofit2.Call
import com.example.unograham.io.response.LoginResponse
import com.example.unograham.io.response.PartidasGanadasResponse
import com.example.unograham.io.response.RegisterResponse
import com.example.unograham.model.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    // Métodos para autenticación
    @POST("login")
    fun postlogin(@Query("user") user: String, @Query("password") password: String): Call<LoginResponse>

    @POST("register")
    fun postRegister(@Query("user") user: String, @Query("email") email: String, @Query("password") password: String): Call<RegisterResponse>

    // Métodos para manejo de amigos
    //Mandar solicitud de amistad
    @POST("send_friend_request")
    fun sendFriendRequest(@Query("sender_id") senderId: String, @Query("receiver_id") receiverId: String): Call<FriendRequestResponse>

    //Aceptar solicitud de amistad
    @POST("accept_friend_request")
    fun acceptFriendRequest(@Query("sender_id") senderId: String, @Query("receiver_id") receiverId: String): Call<FriendRequestResponse>

    //Rechazar solicitud de amistad
    @POST("reject_friend_request")
    fun rejectFriendRequest(@Query("sender_id") senderId: String, @Query("receiver_id") receiverId: String): Call<FriendRequestResponse>

    //Eliminar amigo
    @POST("remove_friend")
    fun removeFriend(@Query("user_id") userId: String, @Query("friend_id") friendId: String): Call<FriendRequestResponse>

    //Obtener lista de amigos
    @GET("get_friends")
    fun getFriends(@Query("user_id") userId: String): Call<List<Friend>>

    // Método para obtener las solicitudes de amistad
    @GET("get_friend_requests")
    fun getFriendRequests(@Query("user_id") userId: String): Call<List<Friend>>

    // Obtener el número de partidas ganadas por un usuario
    @GET("get_user_wins")
    fun getUserWins(@Query("user_id") userId: String): Call<PartidasGanadasResponse>

    // Obtener información del usuario por su ID
    @GET("get_user")
    fun getUser(@Query("username") username: String): Call<User>

    companion object Factory {
        private const val BASE_URL = "http://your_api_base_url.com/"

        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(ApiService::class.java)
        }
    }
}