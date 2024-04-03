package com.example.unograham.io.response

import com.example.unograham.model.User

data class LoginResponse(
    val success: Boolean,   //si el inicio fué exitoso o no
    val  user: User,       //detalles del ususario User (User.kt)
    val jvt: String       //token de autenticación
)
