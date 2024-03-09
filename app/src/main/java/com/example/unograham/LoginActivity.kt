package com.example.unograham

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.unograham.databinding.ActivityLoginBinding
import android.content.Context


class LoginActivity : AppCompatActivity() {

    // Utilizamos lateinit para inicializar binding más adelante
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializamos el binding
        binding = ActivityLoginBinding.inflate(layoutInflater)

        //binding = ActivityLoginBinding.inflate(layoutInflater)

        //setContentView(R.layout.activity_login)
        // Inicializamos el binding
        binding = ActivityLoginBinding.inflate(layoutInflater)

        // Establecemos el contenido de la actividad utilizando el objeto binding.root
        setContentView(binding.root)

        // Configuramos el evento clic del botón de inicio de sesión
        binding.buttonLogin.setOnClickListener {
            val username = binding.editTextUsername.text.toString()
            val password = binding.editTextPassword.text.toString()

            // Aquí agregarías la lógica para verificar el nombre de usuario y la contraseña
            // Por ahora, simplemente estamos comprobando que ambos campos no estén vacíos
            if (username.isNotEmpty() && password.isNotEmpty()) {
                // Si las credenciales son válidas, iniciamos la actividad MenuActivity
                val intent = Intent(this, PantallaInicio::class.java)
                startActivity(intent)
                finish() // Finalizamos la actividad actual para evitar que el usuario regrese aquí usando el botón "Atrás"
            } else {
                // Mostramos un mensaje de error si el campo de usuario o contraseña está vacío
                // Aquí puedes mostrar un Toast o un Snackbar con un mensaje de error
            }
        }


        /*// Configurar el evento clic del botón de registro
        binding.buttonRegister.setOnClickListener {
            // Aquí puedes agregar la lógica para manejar el clic del botón de registro
            // Por ejemplo, podrías abrir una nueva actividad para el registro
            val intent = Intent(this, RegisterActivity::class.java)
             startActivity(intent)
        }
    }
}
