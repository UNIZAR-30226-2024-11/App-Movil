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
import java.io.IOException
import android.util.Log


class CrearSalaActivity : AppCompatActivity() {

    private val TAG = "CrearSalaActivity"
    private val BASE_URL = "https://backend-eg2q.onrender.com/api/"
    private lateinit var socket: Socket

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_sala)

        try {
            Log.e(TAG, "empieza el try")
            socket = IO.socket(BASE_URL)
            Log.e(TAG, "socket = IO.socket(Base url)")
            socket.on(Socket.EVENT_CONNECT) {
                Log.d(TAG, "Conectado al servidor")

                val data = JSONObject()
                // Aquí puedes incluir datos para crear la sala, si es necesario
                // data.put("roomName", "Nombre de la Sala")

                socket.emit("create-lobby", data)
            }
            Log.e(TAG, "antes de intentar conexion")
            socket.connect()
            Log.e(TAG, "despues de intenter conexion")

        } catch (e: URISyntaxException) {
            Log.e(TAG, "Error de sintaxis en la URL: ${e.message}")
            e.printStackTrace()
        } catch (e: IOException) {
            Log.e(TAG, "Error de conexión al socket: ${e.message}")
            e.printStackTrace()
        } catch (e: Exception) {
            Log.e(TAG, "Error desconocido: ${e.message}")
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
