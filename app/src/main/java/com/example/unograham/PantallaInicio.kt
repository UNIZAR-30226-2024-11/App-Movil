package com.example.unograham

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PantallaInicio : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
    }
}
