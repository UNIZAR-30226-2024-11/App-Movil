package com.example.unograham

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PerfilActivity : AppCompatActivity() {

        private lateinit var partidasGanadasTextView: TextView
        private lateinit var sharedPreferences: SharedPreferences

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_perfil)

                // Inicializar vistas
                partidasGanadasTextView = findViewById(R.id.partidasGanadasTextView)

                // Inicializar SharedPreferences
                sharedPreferences = getSharedPreferences("my_preference", Context.MODE_PRIVATE)

                // Mostrar el número de partidas ganadas del usuario almacenado en SharedPreferences
                val partidasGanadas = sharedPreferences.getInt("partidas_ganadas", 0)
                partidasGanadasTextView.text = partidasGanadas.toString()

                // Configurar los botones de la barra de navegación
                val cartIconButton = findViewById<ImageButton>(R.id.cartButton)
                val personIconButton = findViewById<ImageButton>(R.id.personButton)
                val settingsIconButton = findViewById<ImageButton>(R.id.settingsButton)
                val logoutIconButton = findViewById<ImageButton>(R.id.logoutButton)
                val homeIconButton = findViewById<ImageButton>(R.id.homeButton)

                cartIconButton.setOnClickListener {
                        startActivity(Intent(this, TiendaActivity::class.java))
                        finish()
                }

                personIconButton.setOnClickListener {
                        startActivity(Intent(this, AmigosActivity::class.java))
                        finish()
                }

                homeIconButton.setOnClickListener {
                        startActivity(Intent(this, PantallaInicioActivity::class.java))
                        finish()
                }

                settingsIconButton.setOnClickListener {
                        startActivity(Intent(this, AjustesActivity::class.java))
                        finish()
                }

                logoutIconButton.setOnClickListener {
                        // Cerrar sesión: eliminar los datos de usuario de SharedPreferences
                        with(sharedPreferences.edit()) {
                                remove("username")
                                remove("coins")
                                remove("xp")
                                remove("level")
                                apply()
                        }
                        // Redirigir al inicio de sesión
                        startActivity(Intent(this, LoginActivity::class.java))
                        finish()
                }
        }
}
