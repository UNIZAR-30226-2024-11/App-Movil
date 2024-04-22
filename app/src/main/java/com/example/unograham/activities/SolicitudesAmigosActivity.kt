package com.example.unograham

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.unograham.R
import com.example.unograham.io.ApiService
import com.example.unograham.io.request.FriendRequest
import com.example.unograham.io.response.FriendResponse
import com.example.unograham.model.Friend
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SolicitudesAmigosActivity : AppCompatActivity() {

   /* private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solicitudes_pendientes)

        apiService = ApiService.create()

        obtenerYMostrarSolicitudesAmistad()
    }

    private fun obtenerYMostrarSolicitudesAmistad() {
        val sharedPreferences = getSharedPreferences("my_preference", Context.MODE_PRIVATE)
        val userId = sharedPreferences.getString("username", "") ?: ""

        apiService.getFriendRequests(userId).enqueue(object : Callback<List<Friend>> {
            override fun onResponse(call: Call<List<Friend>>, response: Response<List<Friend>>) {
                if (response.isSuccessful) {
                    val solicitudes = response.body()
                    if (solicitudes != null) {
                        mostrarSolicitudes(solicitudes)
                    }
                } else {
                    Toast.makeText(applicationContext, "Error al obtener las solicitudes de amistad", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<Friend>>, t: Throwable) {
                Toast.makeText(applicationContext, "Error en la solicitud: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun mostrarSolicitudes(solicitudes: List<Friend>) {
        val solicitudesLayout = findViewById<LinearLayout>(R.id.solicitudesLayout)

        for (solicitud in solicitudes) {
            val solicitudView = layoutInflater.inflate(R.layout.activity_item_solicitudes_pendientes, null)

            val usernameTextView = solicitudView.findViewById<TextView>(R.id.requesterNameTextView)
            usernameTextView.text = solicitud.username

            val avatarImageView = solicitudView.findViewById<ImageView>(R.id.requesterProfileImage)

            val acceptButton = solicitudView.findViewById<Button>(R.id.acceptButton)
            acceptButton.setOnClickListener {
                aceptarSolicitudAmistad(solicitud.username)
                solicitudesLayout.removeView(solicitudView)
            }

            val rejectButton = solicitudView.findViewById<Button>(R.id.declineButton)
            rejectButton.setOnClickListener {
                rechazarSolicitudAmistad(solicitud.username)
                solicitudesLayout.removeView(solicitudView)
            }

            solicitudesLayout.addView(solicitudView)
        }
    }

    private fun aceptarSolicitudAmistad(username: String) {
        val sharedPreferences = getSharedPreferences("my_preference", Context.MODE_PRIVATE)
        val userId = sharedPreferences.getString("username", "") ?: ""

        apiService.acceptFriendRequest(userId, username).enqueue(object : Callback<FriendResponse> {
            override fun onResponse(call: Call<FriendResponse>, response: Response<FriendResponse>) {
                if (response.isSuccessful) {
                    // La solicitud de amistad fue aceptada correctamente
                    Toast.makeText(applicationContext, "Solicitud de amistad aceptada para $username", Toast.LENGTH_SHORT).show()
                } else {
                    // Error al aceptar la solicitud de amistad
                    Toast.makeText(applicationContext, "Error al aceptar la solicitud de amistad para $username", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<FriendResponse>, t: Throwable) {
                // Manejar error de conexión o solicitud
                Toast.makeText(applicationContext, "Error en la solicitud: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun rechazarSolicitudAmistad(username: String) {
        val sharedPreferences = getSharedPreferences("my_preference", Context.MODE_PRIVATE)
        val userId = sharedPreferences.getString("username", "") ?: ""

        apiService.rejectFriendRequest(userId, username).enqueue(object : Callback<FriendResponse> {
            override fun onResponse(call: Call<FriendResponse>, response: Response<FriendResponse>) {
                if (response.isSuccessful) {
                    // La solicitud de amistad fue rechazada correctamente
                    Toast.makeText(applicationContext, "Solicitud de amistad rechazada para $username", Toast.LENGTH_SHORT).show()
                } else {
                    // Error al rechazar la solicitud de amistad
                    Toast.makeText(applicationContext, "Error al rechazar la solicitud de amistad para $username", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<FriendResponse>, t: Throwable) {
                // Manejar error de conexión o solicitud
                Toast.makeText(applicationContext, "Error en la solicitud: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }*/

}
