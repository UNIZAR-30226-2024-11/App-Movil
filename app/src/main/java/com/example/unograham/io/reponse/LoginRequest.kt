package com.example.unograham.io.reponse

import com.example.unograham.model.User

data class LoginRequest(
    val email: String,
    val password: String
)
