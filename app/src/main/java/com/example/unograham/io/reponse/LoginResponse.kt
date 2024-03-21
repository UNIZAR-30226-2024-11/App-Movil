package com.example.unograham.io.reponse

import com.example.unograham.model.User

data class LoginResponse(
    val success: Boolean,
    val  user: User,
    val jvt: String
)
