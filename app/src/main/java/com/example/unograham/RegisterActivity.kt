package com.example.unograham

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

/**
 * Register activity
 *
 * @constructor Create empty Register activity
 */
class RegisterActivity : AppCompatActivity() {

    /**
     * Método llamado cuando se crea la actividad de carga. Aquí es donde se establece el
     * diseño de la actividad y se inicializan otros componentes necesarios.
     *
     * @param savedInstanceState El estado de la instancia guardada de la actividad.
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Referenciamos el botón de registro desde el layout
        val buttonRegister: Button = findViewById(R.id.buttonRegister)

        // Configuramos el evento clic del botón de registro
        buttonRegister.setOnClickListener {
            // Aquí deberías agregar la lógica para procesar el registro y almacenar los datos
            // Puedes agregar la lógica de registro aquí antes de navegar a la pantalla de menú

            // Después de completar el registro, iniciamos la actividad del menú
            val intent = Intent(this, PantallaInicioActivity::class.java)
            startActivity(intent)
            finish() // Esto cierra la actividad actual, evitando que el usuario regrese a la pantalla de registro con el botón "Atrás"
        }
    }
}
