package com.example.unograham

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.unograham.databinding.ActivityLoginBinding
import android.content.Context
import android.widget.Button
import android.widget.ImageButton

class PantallaInicioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_inicio)


        // Manejo de los botones
        val createGameButton = findViewById<Button>(R.id.createGameButton)
        val joinGameButton = findViewById<Button>(R.id.joinGameButton)
        val tournamentButton = findViewById<Button>(R.id.tournamentButton)
        val cartIconButton = findViewById<ImageButton>(R.id.cartIcon)
        val personIconButton = findViewById<ImageButton>(R.id.personIcon)
        val settingsIconButton = findViewById<ImageButton>(R.id.settingsIcon)
        val profileImageButton = findViewById<ImageButton>(R.id.profileImage)


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
        cartIconButton.setOnClickListener {
            val intent = Intent(this, TiendaActivity::class.java)
            startActivity(intent)
            finish()
        }

        personIconButton.setOnClickListener {
            val intent = Intent(this, AmigosActivity::class.java)
            startActivity(intent)
            finish()
        }

        settingsIconButton.setOnClickListener {
            val intent = Intent(this, AjustesActivity::class.java)
            startActivity(intent)
            finish()
        }

        profileImageButton.setOnClickListener {
            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
