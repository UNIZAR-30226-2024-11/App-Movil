package com.example.unograham

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class AjustesActivity : AppCompatActivity() {

    /**
     * Método llamado cuando se crea la actividad. Aquí es donde se inicializan
     * los componentes de la interfaz de usuario, se configuran los listeners y
     * se realizan otras operaciones de inicialización.
     *
     * @param savedInstanceState El estado de la instancia guardada de la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ajustes)

        val backArrowButton = findViewById<ImageButton>(R.id.backArrow)

        backArrowButton.setOnClickListener {
            val intent = Intent(this, PantallaInicioActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}