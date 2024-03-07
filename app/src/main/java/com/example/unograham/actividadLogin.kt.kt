package com.example.unograham

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import android.content.Intent

class `actividadLogin.kt` : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Configurar el evento clic del botón de inicio de sesión
        btn_login.setOnClickListener {
            val username = et_username.text.toString()
            val password = et_password.text.toString()

            // Aquí agregarías la lógica para verificar el nombre de usuario y la contraseña
            // Por ahora, simplemente estamos iniciando una nueva actividad como ejemplo
            if (username.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Mostrar un mensaje de error si el campo de usuario o contraseña está vacío
                // Aquí puedes mostrar un Toast o un Snackbar con un mensaje de error
            }
        }
    }
}
