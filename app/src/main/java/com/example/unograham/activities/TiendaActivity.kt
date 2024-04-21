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

        //cargarAvatares()  no funciona bien
        //aplicarEscalaDeGrises(findViewById<ImageView>(R.id.avatar1ImageView))




        val backArrowButton = findViewById<ImageButton>(R.id.backArrow)

        backArrowButton.setOnClickListener {
            val intent = Intent(this, PantallaInicioActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun elegirAvatar(avatar: Int, avatarImageView: ImageView){
        Preferencias.guardarValorEntero("avatar_en_uso", avatar)

    }
    //inicializar el id de los avatares,
    private fun cargarAvatares(){
        var avatarImageView = findViewById<ImageView>(R.id.avatar1ImageView)
        cargarAvatar(avatarImageView, 1)
        avatarImageView = findViewById<ImageView>(R.id.avatar2ImageView)
        cargarAvatar(avatarImageView, 2)
        avatarImageView = findViewById<ImageView>(R.id.avatar3ImageView)
        cargarAvatar(avatarImageView, 3)
        avatarImageView = findViewById<ImageView>(R.id.avatar4ImageView)
        cargarAvatar(avatarImageView, 4)
        avatarImageView = findViewById<ImageView>(R.id.avatar5ImageView)
        cargarAvatar(avatarImageView, 5)
        avatarImageView = findViewById<ImageView>(R.id.avatar6ImageView)
        cargarAvatar(avatarImageView, 6)
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
    matrix.setSaturation(1f) // Configurar la saturación a 1 para quitar la escala de grises

    val filter = ColorMatrixColorFilter(matrix)
    avatar.colorFilter = filter
}


//font-family: Raleway, serif;
//"https://fonts.googleapis.com/css?family=Raleway:400,400i,700"