package com.dam2.simon

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = "Bienvenido a la cúpula del trueno"
        val duration = Toast.LENGTH_LONG

        val toast = Toast.makeText(applicationContext, text, duration)
        toast.show()































    }
}
