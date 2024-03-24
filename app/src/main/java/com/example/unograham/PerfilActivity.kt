package com.example.unograham

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class PerfilActivity : AppCompatActivity() {

        /**
         * Método llamado cuando se crea la actividad de carga. Aquí es donde se establece el
         * diseño de la actividad y se inicializan otros componentes necesarios.
         *
         * @param savedInstanceState El estado de la instancia guardada de la actividad.
         */

        override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_perfil)

                val backArrowButton = findViewById<ImageButton>(R.id.backArrow)

                backArrowButton.setOnClickListener {
                        val intent = Intent(this, PantallaInicioActivity::class.java)
                        startActivity(intent)
                        finish()
                }
        }


}