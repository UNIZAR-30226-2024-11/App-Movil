package com.example.unograham.activities;

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.unograham.databinding.ActivityLoginBinding
import com.example.unograham.io.ApiService
import com.example.unograham.io.reponse.LoginResponse
import com.example.unograham.io.request.LoginRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.unograham.utils.Preferencias

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var apiService: ApiService
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        apiService = ApiService.create()
        //sharedPreferences = getSharedPreferences("my_preference", Context.MODE_PRIVATE)

        binding.loginButton.setOnClickListener {
            val email = binding.username.text.toString()
            val password = binding.password.text.toString()

            val request = LoginRequest(email, password)

            if (email.isNotEmpty() && password.isNotEmpty()) {
                apiService.postlogin(request).enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        if (response.isSuccessful) {
                            val loginResponse = response.body()
                            if (loginResponse != null && loginResponse.token != null) {

                                // Guardar estado de inicio de sesión y atributos del usuario en SharedPreferences
                                Preferencias.guardarValorBooleano("is_logged_in", true)
    //DESCOMENTAR ESTO CUANDO EL BACKEND HAGA BIEN LA RESPUESTA, IGUAL HAY QUE MODIFICAR User.kt
                                //Preferencias.guardarValorEntero("avatar", loginResponse.User.avatar)
                                //Preferencias.guardarValorString("Nombre", loginResponse.User.nombre)
                                //...

                                val intent = Intent(this@LoginActivity, PantallaInicioActivity::class.java)
                                startActivity(intent)
                                finish()
                            } else {
                                Toast.makeText(this@LoginActivity, "Inicio de sesión fallido", Toast.LENGTH_SHORT).show()
                            }
                        } else {
                            Toast.makeText(this@LoginActivity, "Error en la solicitud", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(this@LoginActivity, "Error en la solicitud: ${t.message}", Toast.LENGTH_SHORT).show()
                    }
                })
            } else {
                Toast.makeText(this@LoginActivity, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        binding.registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
