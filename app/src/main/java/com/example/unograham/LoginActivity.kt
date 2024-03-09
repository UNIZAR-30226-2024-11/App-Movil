package com.example.unograham

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.unograham.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    // Utilizamos lateinit para inicializar binding más adelante
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializamos el binding
        //binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_login)

        // Configuramos el evento clic del botón de inicio de sesión
        /*binding.buttonLogin.setOnClickListener {
            val username = binding.editTextUsername.text.toString()
            val password = binding.editTextPassword.text.toString()

            // Aquí agregarías la lógica para verificar el nombre de usuario y la contraseña
            // Por ahora, simplemente estamos iniciando una nueva actividad como ejemplo
            if (username.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this, MenuActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Mostrar un mensaje de error si el campo de usuario o contraseña está vacío
                // Aquí puedes mostrar un Toast o un Snackbar con un mensaje de error
            }
        }

        // Configurar el evento clic del botón de registro
        binding.buttonRegister.setOnClickListener {
            // Aquí puedes agregar la lógica para manejar el clic del botón de registro
            // Por ejemplo, podrías abrir una nueva actividad para el registro
            //val intent = Intent(this, RegisterActivity::class.java)
            // startActivity(intent)
        }*/
    }
}
