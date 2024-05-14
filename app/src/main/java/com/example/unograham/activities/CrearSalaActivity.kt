package com.example.unograham.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast

import com.example.unograham.R
import io.socket.client.IO
import io.socket.client.Socket
import org.json.JSONObject
import java.net.URISyntaxException

class CrearSalaActivity : AppCompatActivity(){

    private val BASE_URL = "https://backend-eg2q.onrender.com/api/"
    private lateinit var socket: Socket
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_sala)

            try {
                socket = IO.socket(BASE_URL)

                socket.on(Socket.EVENT_CONNECT) {
                    Toast.makeText(this@CrearSalaActivity, "conectado al servidor", Toast.LENGTH_SHORT).show()
                    
                    val data = JSONObject()
                    socket.emit("create-lobby", data)
                }

                socket.connect()

            } catch (e: URISyntaxException) {
                e.printStackTrace()
            }
        }

        override fun onDestroy() {
            super.onDestroy()
            socket.disconnect()
        }
}






//fun main() {
//    try {
//        val socket = IO.socket("http://your-socket-io-server-url")
//
//        socket.on(Socket.EVENT_CONNECT) {
//            println("Conectado al servidor")
//
//            // Ejemplo de solicitud para crear una sala
//            val data = JSONObject()
//            data.put("roomName", "Nombre de la Sala")
//
//            socket.emit("create-lobby", data)
//        }
//
//        socket.connect()
//
//    } catch (e: URISyntaxException) {
//        e.printStackTrace()
//    }
//}
