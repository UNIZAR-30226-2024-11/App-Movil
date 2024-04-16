package com.example.unograham;

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.unograham.R

class UnirsePartidaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_unirse_partida)

        // Obtener referencia al botón "Unirse"
        val joinButton = findViewById<Button>(R.id.joinButton)

        // Agregar un OnClickListener al botón "Unirse"
        joinButton.setOnClickListener {
            // Crear un Intent para iniciar la actividad PartidaActivity
            val intent = Intent(this, PartidaActivity::class.java)
            // Iniciar la actividad PartidaActivity
            startActivity(intent)
        }
    }
}
