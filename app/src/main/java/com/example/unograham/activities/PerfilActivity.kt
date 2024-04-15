package com.example.unograham.activities

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.unograham.R

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