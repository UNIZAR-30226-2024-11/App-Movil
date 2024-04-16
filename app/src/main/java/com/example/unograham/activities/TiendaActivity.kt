package com.example.unograham.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.unograham.R
import android.widget.ImageView
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import com.example.unograham.utils.Preferencias

class TiendaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tienda)

        cargarAvatar(,1)


        val backArrowButton = findViewById<ImageButton>(R.id.backArrow)

        backArrowButton.setOnClickListener {
            val intent = Intent(this, PantallaInicioActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}


fun elegirAvatar(avatarImageView: ImageView) {
    // ENVIAR AL BACKEND UNA ACTUALIZACION DEL AVATAR CADA VEZ QUE SE CAMBIE EN LOCAL O SOLO AL FINAL??
    var avatarId = avatarImageView.tag as? Int
    if (avatarId == null) {
        avatarId = 1
    }
    Preferencias.guardarValorEntero("avatar", avatarId)
    quitarEscalaDeGrises(avatarImageView)
    //actualizar backend?
}

//Para asociar a cada avatar un id entero y poder tener guardado cual se esta usando, y poder recibir y enviar al backend
fun cargarAvatar(avatarImageView: ImageView, avatarId: Int) {
    avatarImageView.setImageResource(avatarId)
    avatarImageView.tag = avatarId // Guardar el ID del avatar como una etiqueta en el ImageView
}


fun aplicarEscalaDeGrises(avatar: ImageView) {
    val matrix = ColorMatrix()
    matrix.setSaturation(0f) // Configurar la saturación a 0 para obtener una imagen en escala de grises

    val filter = ColorMatrixColorFilter(matrix)
    avatar.colorFilter = filter
}

fun quitarEscalaDeGrises(avatar: ImageView) {
    val matrix = ColorMatrix()
    matrix.setSaturation(1f) // Configurar la saturación a 0 para obtener una imagen en escala de grises

    val filter = ColorMatrixColorFilter(matrix)
    avatar.colorFilter = filter
}

fun avatarToInt(avatarImageView: ImageView) :Int {

    val option = avatarImageView.

    when (option) {
         -> {
            return 1
        }
         -> {
            return 2
        }
         -> {
           return 3
        }
        else -> {
            println("Opción no reconocida")
            // Código para cualquier otro caso
        }
    }
    return
}
