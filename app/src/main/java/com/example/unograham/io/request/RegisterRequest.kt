package com.example.unograham.io.response

data class RegisterRequest(
    val success: Boolean,        //el registro fue exitoso o no
    val message: String          //algún mensaje?
)
