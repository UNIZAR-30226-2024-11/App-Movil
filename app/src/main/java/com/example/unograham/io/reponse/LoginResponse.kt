package com.example.unograham.io.reponse

import com.example.unograham.model.User

data class LoginResponse(
    val  user: User,       //detalles del ususario User (User.kt)
    val token: String?,    //token de autenticación
    val error: String?     //si hay algun error

)