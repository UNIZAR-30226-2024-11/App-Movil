package com.example.unograham

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity

class PerfilActivity : AppCompatActivity() {

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