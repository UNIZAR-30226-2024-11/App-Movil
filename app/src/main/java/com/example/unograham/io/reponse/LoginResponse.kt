package com.example.unograham.io.reponse

import com.example.unograham.model.User

data class LoginResponse(
    //val  user: User,       //detalles del ususario User (User.kt)
    val error: String?,     //si hay algun error
    val token: String?    //token de autenticación


)