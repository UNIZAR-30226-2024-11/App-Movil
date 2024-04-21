package com.example.unograham;

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.unograham.R
import com.example.unograham.databinding.ActivityPantallaInicioBinding
import com.example.unograham.io.ApiService
import com.example.unograham.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PantallaInicioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPantallaInicioBinding
    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_inicio)


        // Manejo de los botones
        val createGameButton = findViewById<Button>(R.id.createGameButton)
        val joinGameButton = findViewById<Button>(R.id.joinGameButton)
        val tournamentButton = findViewById<Button>(R.id.tournamentButton)
        val cartIconButton = findViewById<ImageButton>(R.id.cartButton)
        val personIconButton = findViewById<ImageButton>(R.id.personButton)
        val settingsIconButton = findViewById<ImageButton>(R.id.settingsButton)
        val logoutIconButton = findViewById<ImageButton>(R.id.logoutButton)
        val profileImageButton = findViewById<ImageButton>(R.id.profileImageView)


        createGameButton.setOnClickListener {
            // Lógica para el botón "Crear Partida"
            val intent = Intent(this, CrearPartidaActivity::class.java)
            startActivity(intent)
            finish()
        }

        joinGameButton.setOnClickListener {
            // Lógica para el botón "Unirse a Partida"
            val intent = Intent(this, UnirsePartidaActivity::class.java)
            startActivity(intent)
            finish()
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

        logoutIconButton.setOnClickListener {
            //IMPLEMENTAR CERRAR SESIÓN :)
            //val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)
            finish()
        }

        profileImageButton.setOnClickListener {
            val intent = Intent(this, PerfilActivity::class.java)
            startActivity(intent)
            finish()
        }

        //obtenerYGuardarPerfil()
    }

    /*
    private fun obtenerYGuardarPerfil() {
        val sharedPreferences = getSharedPreferences("my_preference", Context.MODE_PRIVATE)
        val userId = sharedPreferences.getString("username", "") ?: ""

        apiService.getUser(userId).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    val user = response.body()
                    if (user != null) {
                        // Actualizar las variables con los datos del usuario obtenidos del servidor
                        val avatar = user.avatar
                        val xp = user.xp
                        val monedas = user.monedas
                        val nivel = user.nivel

                        // Aquí puedes hacer lo que necesites con estos datos, como guardarlos en SharedPreferences
                        guardarDatosUsuarioEnSharedPreferences(avatar, xp, monedas, nivel)
                    }
                } else {
                    // Manejar el error si la llamada no fue exitosa
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                // Manejar el error si la llamada falló
            }
        })
    }

    private fun guardarDatosUsuarioEnSharedPreferences(avatar: String, xp: Int, monedas: Int, nivel: Int) {
        val sharedPreferences = getSharedPreferences("my_preference", Context.MODE_PRIVATE)
        with(sharedPreferences.edit()) {
            putString("avatar", avatar)
            putInt("xp", xp)
            putInt("monedas", monedas)
            putInt("nivel", nivel)
            apply()
        }
    }

     */

}
