package com.example.unograham

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.unograham.activities.PantallaInicioActivity
import com.example.unograham.io.ApiService
import com.example.unograham.io.request.FriendRemoveRequest
import com.example.unograham.io.request.FriendRequest
import com.example.unograham.io.response.FriendResponse
import com.example.unograham.model.Friend
import com.example.unograham.utils.Preferencias
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AmigosActivity : AppCompatActivity() {

    private lateinit var apiService: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_amigos)

        apiService = ApiService.create()

        val backArrowButton = findViewById<ImageButton>(R.id.backArrow)
        val enviarSolicitudButton = findViewById<Button>(R.id.sendRequestButton)
        val verSolicitudesAmistad = findViewById<Button>(R.id.ButtonSolicitudes)

        backArrowButton.setOnClickListener {
            val intent = Intent(this, PantallaInicioActivity::class.java)
            startActivity(intent)
            finish()
        }

        enviarSolicitudButton.setOnClickListener {
            //val sharedPreferences = getSharedPreferences("my_preference", Context.MODE_PRIVATE)
            //val username = sharedPreferences.getString("username", "")
            // Obtener el nombre de usuario
            val username = Preferencias.obtenerValorString("username", "")


            val request = FriendRequest(username.toString())

            val searchQuery = findViewById<EditText>(R.id.searchEditText).text.toString()

            if (!username.isNullOrEmpty() && !searchQuery.isNullOrEmpty()) {
                apiService.sendFriendRequest(request).enqueue(object : Callback<FriendResponse> {
                    override fun onResponse(call: Call<FriendResponse>, response: Response<FriendResponse>) {
                        if (response.isSuccessful) {
                            // Procesar respuesta exitosa
                            Toast.makeText(applicationContext, "Solicitud de amistad enviada", Toast.LENGTH_SHORT).show()
                        } else {
                            // Manejar error de solicitud
                            Toast.makeText(applicationContext, "Error en la solicitud", Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onFailure(call: Call<FriendResponse>, t: Throwable) {
                        // Manejar fallo de solicitud
                        Toast.makeText(applicationContext, "Error en la solicitud: ${t.message}", Toast.LENGTH_SHORT).show()
                    }
                })
            } else {
                // Mostrar mensaje si los campos están vacíos
                Toast.makeText(applicationContext, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            }
        }

        verSolicitudesAmistad.setOnClickListener {
            val intent = Intent(this, SolicitudesAmigosActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Obtener la lista de amigos y mostrarlos
        obtenerYMostrarAmigos()
    }

    private fun obtenerYMostrarAmigos() {
        val sharedPreferences = getSharedPreferences("my_preference", Context.MODE_PRIVATE)
        val userId = sharedPreferences.getString("username", "") ?: ""

        val request = FriendRequest(userId.toString())

        apiService.getFriends(request).enqueue(object : Callback<FriendResponse> {
            override fun onResponse(call: Call<FriendResponse>, response: Response<FriendResponse>) {
                if (response.isSuccessful) {
                    val friendResponse = response.body()
                    if (friendResponse != null) {
                        // Aquí puedes acceder a los datos de FriendResponse según sea necesario
                        val amigos = friendResponse.amigos // Suponiendo que 'amigos' es una lista de amigos en FriendResponse
                        if (amigos != null) {
                            mostrarAmigos(userId, amigos)
                        } else {
                            // Manejar el caso donde la lista de amigos es nula
                            Toast.makeText(applicationContext, "La lista de amigos es nula", Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(applicationContext, "Error al obtener la lista de amigos", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<FriendResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "Error en la solicitud: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun mostrarAmigos(userId: String, amigos: List<Friend>) {
        val amigosLayout = findViewById<LinearLayout>(R.id.avatarsGridLayout)

        for (amigo in amigos) {
            val amigoView = layoutInflater.inflate(R.layout.activity_item_amigos, null)

            val nombreAmigoTextView = amigoView.findViewById<TextView>(R.id.nombreAmigoTextView)
            nombreAmigoTextView.text = amigo.username

            // Cargar la imagen de perfil del amigo
            val avatarImageView = amigoView.findViewById<ImageView>(R.id.avatarImageView)
            val resourceId = resources.getIdentifier(amigo.profileImage, "drawable", packageName)
            if (resourceId != 0) {
                avatarImageView.setImageResource(resourceId)
            } else {
                // Si no se encuentra la imagen, mostrar una imagen predeterminada o un mensaje de error
                //avatarImageView.setImageResource(R.drawable.default_avatar)
                // También puedes mostrar un mensaje de error
                Toast.makeText(applicationContext, "No se encontró la imagen de perfil para ${amigo.username}", Toast.LENGTH_SHORT).show()
            }

            // Agregar un listener al botón de eliminar amigo
            val deleteFriendButton = amigoView.findViewById<ImageButton>(R.id.deleteFriendButton)
            deleteFriendButton.setOnClickListener {
                // Eliminar el amigo de la lista
                amigosLayout.removeView(amigoView)
                // Notificar a la API sobre la eliminación del amigo (aquí debes llamar al método correspondiente en ApiService)
                eliminarAmigo(userId,amigo.username)

            }

            amigosLayout.addView(amigoView)
        }
    }

    private fun eliminarAmigo(username: String, amigoUsername: String) {
        // Llamar al método de la API para eliminar al amigo
        val request = FriendRemoveRequest(username, amigoUsername)
        apiService.removeFriend(request).enqueue(object : Callback<FriendResponse> {
            override fun onResponse(call: Call<FriendResponse>, response: Response<FriendResponse>) {
                if (response.isSuccessful) {
                    // La eliminación fue exitosa, puedes realizar acciones adicionales si es necesario
                } else {
                    // Manejar errores de respuesta si la eliminación falla
                    Toast.makeText(applicationContext, "Error al eliminar amigo", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<FriendResponse>, t: Throwable) {
                // Manejar errores de conexión o solicitud
                Toast.makeText(applicationContext, "Error en la solicitud: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }

}
