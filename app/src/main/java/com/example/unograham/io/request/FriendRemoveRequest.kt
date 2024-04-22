package com.example.unograham.io.request

data class FriendRemoveRequest (
    val username: String,     //Usuario
    val friendUsername: String //Amigo que quiere eliminar
)