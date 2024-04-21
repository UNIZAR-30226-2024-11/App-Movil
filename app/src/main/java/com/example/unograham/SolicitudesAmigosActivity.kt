package com.example.unograham

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SolicitudesAmigosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_solicitudes_amistad)

        obtenerYMostrarSolicitudesAmistad()
    }

    private fun obtenerYMostrarSolicitudesAmistad() {
        // Simulación de obtención de solicitudes de amistad
        val solicitudes = obtenerSolicitudesDeAmistad()

        if (solicitudes.isNotEmpty()) {
            mostrarSolicitudes(solicitudes)
        } else {
            Toast.makeText(applicationContext, "No hay solicitudes de amistad pendientes", Toast.LENGTH_SHORT).show()
        }
    }

    private fun obtenerSolicitudesDeAmistad(): List<String> {
        // Aquí se puede implementar la lógica para obtener las solicitudes de amistad
        // Por ejemplo, obtener datos de SharedPreferences, base de datos local, etc.
        // En esta simulación, se devuelve una lista de ejemplo
        return listOf("Usuario1", "Usuario2", "Usuario3")
    }

    private fun mostrarSolicitudes(solicitudes: List<String>) {
        val solicitudesLayout = findViewById<LinearLayout>(R.id.solicitudesLayout)

        for (solicitud in solicitudes) {
            val solicitudView = layoutInflater.inflate(R.layout.activity_item_solicitudes_pendientes, null)

            val usernameTextView = solicitudView.findViewById<TextView>(R.id.requesterNameTextView)
            usernameTextView.text = solicitud

            // Aquí se puede cargar la imagen de perfil del solicitante, si es necesario

            val acceptButton = solicitudView.findViewById<Button>(R.id.acceptButton)
            acceptButton.setOnClickListener {
                aceptarSolicitudAmistad(solicitud)
                solicitudesLayout.removeView(solicitudView)
            }

            val rejectButton = solicitudView.findViewById<Button>(R.id.declineButton)
            rejectButton.setOnClickListener {
                rechazarSolicitudAmistad(solicitud)
                solicitudesLayout.removeView(solicitudView)
            }

            solicitudesLayout.addView(solicitudView)
        }
    }

    private fun aceptarSolicitudAmistad(username: String) {
        // Aquí se puede implementar la lógica para aceptar la solicitud de amistad
        Toast.makeText(applicationContext, "Solicitud de amistad aceptada para $username", Toast.LENGTH_SHORT).show()
    }

    private fun rechazarSolicitudAmistad(username: String) {
        // Aquí se puede implementar la lógica para rechazar la solicitud de amistad
        Toast.makeText(applicationContext, "Solicitud de amistad rechazada para $username", Toast.LENGTH_SHORT).show()
    }

}
