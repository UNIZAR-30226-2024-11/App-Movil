package com.example.unograham

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.unograham.io.ApiService
import com.example.unograham.io.response.PartidasGanadasResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

                // Obtener y mostrar el número de partidas ganadas del usuario
                obtenerYMostrarPartidasGanadas()
        }

        private fun obtenerYMostrarPartidasGanadas() {
                val apiService = ApiService.create()

                val username = sharedPreferences.getString("username", "")?: ""

                val call = apiService.getUserWins(username)
                call.enqueue(object : Callback<PartidasGanadasResponse> {
                        override fun onResponse(call: Call<PartidasGanadasResponse>, response: Response<PartidasGanadasResponse>) {
                                if (response.isSuccessful) {
                                        val partidasGanadasResponse = response.body()
                                        partidasGanadasTextView.text = partidasGanadasResponse?.partidasGanadas.toString()
                                } else {
                                        // Manejar el error si la llamada no fue exitosa
                                }
                        }

                        override fun onFailure(call: Call<PartidasGanadasResponse>, t: Throwable) {
                                // Manejar el error si la llamada falló
                        }
                })
        }
}
