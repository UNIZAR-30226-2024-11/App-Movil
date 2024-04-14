package com.example.unograham.io.request

import com.example.unograham.model.User

data class LoginRequest(
    val email: String,
    val password: String
)

//interface LoginRequest {
//    email: string
//    password: string
//}