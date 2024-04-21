package com.example.unograham.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.unograham.MiApp


object Preferencias {
    private const val PREFS_NAME = "mis_preferencias"
    private val sharedPreferences: SharedPreferences by lazy {
        MiApp.instance.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }
    fun guardarValorString(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }
    fun obtenerValorString(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun guardarValorBooleano(key: String, value: Boolean) {
        sharedPreferences.edit().putBoolean(key, value).apply()
    }
    fun obtenerValorBooleano(key: String, defaultValue: Boolean): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    fun guardarValorEntero(key: String, value: Int) {
        sharedPreferences.edit().putInt(key, value).apply()
    }
    fun obtenerValorEntero(key: String, defaultValue: Int): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }
}

/*
BOOELANOS
    is_logged_in

ENTEROS
    avatar_en_uso

STRINGS


*/