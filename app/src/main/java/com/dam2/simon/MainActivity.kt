package com.dam2.simon

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val introduccion = "Bienvenido a la cúpula del trueno"
        val duration = Toast.LENGTH_LONG
        val toastApertura = Toast.makeText(applicationContext, introduccion, duration)
        toastApertura.show()

        var state: Boolean

        val empezar: Button = findViewById(R.id.startButton)
        val comprobar: Button = findViewById(R.id.checkButton)
        val btnRojo: Button = findViewById(R.id.bRojo)
        val btnAzul: Button = findViewById(R.id.bAzul)
        val btnAmarillo: Button = findViewById(R.id.bAmarillo)
        val btnVerde: Button = findViewById(R.id.bVerde)
        val Btnscolor = listOf(btnAmarillo, btnAzul, btnRojo, btnVerde)
        val toast = Toast.makeText(applicationContext,"Juego terminado", Toast.LENGTH_SHORT)
        val toast2 = Toast.makeText(applicationContext,"Inicio", Toast.LENGTH_SHORT)

        val Partida by viewModels<MyViewModel>()

        Partida.partida.observe(this, Observer {
            ps -> state= ps
            if(state) {
                btnRojo.setEnabled(false)
                btnAzul.setEnabled(false)
                btnAmarillo.setEnabled(false)
                btnVerde.setEnabled(false)
                comprobar.setEnabled(false)
            }else{
                btnRojo.setEnabled(true)
                btnAzul.setEnabled(true)
                btnAmarillo.setEnabled(true)
                btnVerde.setEnabled(true)
                comprobar.setEnabled(true)
            }
        })


        Partida.secuenciaUser.observe(this, Observer{
            Partida.mostrarSecuencia(Btnscolor)
        })

        empezar.setOnClickListener{
            toast2.show()
            Partida.iniciarJuego()
        }

        comprobar.setOnClickListener{
            if(!Partida.comprobar()){
                toast.show()
            }
        }
        btnRojo.setOnClickListener{
            Partida.añadirSecuenciaUser(1)
        }
        btnAzul.setOnClickListener{
            Partida.añadirSecuenciaUser(2)
        }
        btnAmarillo.setOnClickListener{
            Partida.añadirSecuenciaUser(3)
        }
        btnVerde.setOnClickListener{
            Partida.añadirSecuenciaUser(4)
        }
    }
}

































        /*val toastComenzamos = Toast.makeText(applicationContext,"Empieza el juego",duration)

        val info: TextView = findViewById(R.id.rondas)

        val verRonda by viewModels<MyViewModel>()

        verRonda.ronda.observe(this, Observer{
                resetRonda -> rondas.text = resetRonda.toString()
        })

        val startButton : Button = findViewById(R.id.startButton)
        startButton.setOnClickListener{
            //cambioRojo()
           // cambioAzul()
            //cambioVerde()
            //cambioAmarillo()
            toastComenzamos.show()

        }

        resetButton.setOnClickListener{

                }*/
