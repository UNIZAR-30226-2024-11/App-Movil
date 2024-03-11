package com.example.unograham

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.unograham.databinding.ActivityLoginBinding
import android.content.Context

class PantallaInicio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_inicio)

        /*
        // Manejo de los botones
        val createGameButton = findViewById<Button>(R.id.createGameButton)
        val joinGameButton = findViewById<Button>(R.id.joinGameButton)
        val tournamentButton = findViewById<Button>(R.id.tournamentButton)

        createGameButton.setOnClickListener {
            // Lógica para el botón "Crear Partida"
            // Por ejemplo, puedes abrir una nueva actividad o realizar alguna acción
        }

        joinGameButton.setOnClickListener {
            // Lógica para el botón "Unirse a Partida"
            // Por ejemplo, puedes abrir una nueva actividad o realizar alguna acción
        }

        tournamentButton.setOnClickListener {
            // Lógica para el botón "Torneo"
            // Por ejemplo, puedes abrir una nueva actividad o realizar alguna acción
        }

         */
    }
}
