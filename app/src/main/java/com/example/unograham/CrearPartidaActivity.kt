package com.example.unograham;

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.unograham.R
class CrearPartidaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_crear_partida)

        // Obtener referencia al botón "Comenzar"
        val startButton = findViewById<Button>(R.id.startButton)

        val backArrowButton = findViewById<ImageButton>(R.id.backArrow)

        backArrowButton.setOnClickListener {
            val intent = Intent(this, PantallaInicioActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Agregar un OnClickListener al botón "Unirse"
        startButton.setOnClickListener {
            // Crear un Intent para iniciar la actividad PartidaActivity
            val intent = Intent(this, PartidaActivity::class.java)
            // Iniciar la actividad PartidaActivity
            startActivity(intent)
        }
    }

}
