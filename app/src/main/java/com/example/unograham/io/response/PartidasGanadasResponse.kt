package com.example.unograham.io.response

import com.google.gson.annotations.SerializedName

data class PartidasGanadasResponse(
    @SerializedName("partidas_ganadas")
    val partidasGanadas: Int
)
