package com.example.unograham

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.unograham.ui.theme.UnoGrahamTheme


class ActividadCarga : ComponentActivity() {

    /**
     * Método llamado cuando se crea la actividad de carga. Aquí es donde se establece el
     * diseño de la actividad y se inicializan otros componentes necesarios.
     *
     * @param savedInstanceState El estado de la instancia guardada de la actividad.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.actividad_carga)

        }
    }

