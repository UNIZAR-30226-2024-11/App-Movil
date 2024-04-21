package com.example.unograham

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.unograham.io.ApiService
import com.example.unograham.model.Friend

class AmigosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amigos)

        val backArrowButton = findViewById<ImageButton>(R.id.backArrow)
        val enviarSolicitudButton = findViewById<Button>(R.id.sendRequestButton)
        val verSolicitudesAmistad = findViewById<Button>(R.id.ButtonSolicitudes)

        backArrowButton.setOnClickListener {
            val intent = Intent(this, PantallaInicioActivity::class.java)
            startActivity(intent)
            finish()
        }

        enviarSolicitudButton.setOnClickListener {
            val sharedPreferences = getSharedPreferences("my_preference", Context.MODE_PRIVATE)
            val username = sharedPreferences.getString("username", "")

            val searchQuery = findViewById<EditText>(R.id.searchEditText).text.toString()

            if (!username.isNullOrEmpty() && !searchQuery.isNullOrEmpty()) {
                // Lógica para enviar solicitud de amistad
                Toast.makeText(applicationContext, "Solicitud de amistad enviada", Toast.LENGTH_SHORT).show()
            } else {
                // Mostrar mensaje si los campos están vacíos
                Toast.makeText(applicationContext, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        verSolicitudesAmistad.setOnClickListener {
            val intent = Intent(this, SolicitudesAmigosActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Obtener la lista de amigos y mostrarlos
        obtenerYMostrarAmigos()
    }

    private fun obtenerYMostrarAmigos() {
        // Lógica para obtener y mostrar la lista de amigos
        // Se puede utilizar una lista de ejemplo o cualquier otro método de obtención de datos
    }
}

