package com.example.unograham

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.unograham.R

class PartidaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE // Esta línea establece la orientación horizontal
        setContentView(R.layout.actividad_partida)

        /*
        // Obtener referencias a las vistas
        val tacoRobar = findViewById<ImageView>(R.id.tacoRobar)
        val tacoJugadas = findViewById<ImageView>(R.id.tacoJugadas)
        val cartasJugador4Layout = findViewById<LinearLayout>(R.id.cartasJugador4Layout)
        //val botonUno = findViewById<Button>(R.id.botonUno)

        // Agregar clic listener al taco de robar
        tacoRobar.setOnClickListener {
            // Agregar una carta al jugador cuatro (agrega tu lógica aquí)
            // Por ahora, solo agregaremos una carta de ejemplo
            val nuevaCarta = ImageView(this)
            nuevaCarta.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            nuevaCarta.setImageResource(R.drawable.azul2)
            cartasJugador4Layout.addView(nuevaCarta)
        }

        // Agregar clic listeners a las cartas del jugador cuatro
        for (i in 0 until cartasJugador4Layout.childCount) {
            val carta = cartasJugador4Layout.getChildAt(i) as ImageView
            carta.setOnClickListener {
                // Mover la carta seleccionada al taco de jugadas
                tacoJugadas.setImageDrawable(carta.drawable)
                // Eliminar la carta del jugador cuatro
                cartasJugador4Layout.removeView(carta)
            }
        }

        // Agregar clic listener al botón ¡UNO!
        //botonUno.setOnClickListener {
            // Aquí puedes agregar la lógica para el botón ¡UNO!
        //}
        */
         
    }
}
