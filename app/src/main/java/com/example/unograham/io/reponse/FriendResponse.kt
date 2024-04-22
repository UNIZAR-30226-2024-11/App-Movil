package com.example.unograham.io.response

import com.example.unograham.model.Friend

data class FriendResponse(
    val error: String?,  // Puede ser nulo si no hay error
    val amigos: List<Friend>?  // Lista de amigos, puede ser nulo si hay un error
)