package com.dam2.simon

import android.widget.Button
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class MyViewModel() : ViewModel() {
        val listaColores = MutableLiveData<MutableList<Int>>()
        val secuenciaUser = MutableLiveData<MutableList<Int>>()
        val partida = MutableLiveData<Boolean>()

        init {
            secuenciaUser.value = mutableListOf<Int>()
            listaColores.value = mutableListOf<Int>()
            partida.value = true
        }

        fun iniciarJuego() {
            partida.value = false;
            reset()
            añadirASecuencia()
        }

        private fun añadirASecuencia() {
            val color = Random.nextInt(4) + 1
            //val numb = 1;
            listaColores.value?.add(color)
            listaColores.postValue(listaColores.value)
        }

        fun comprobar(): Boolean {
            var retirar = false
            if (listaColores.value == secuenciaUser.value && partida.value == false) {
                añadirASecuencia()
                secuenciaUser.value?.clear()
                retirar = true;
            } else {
                partida.value = true;
            }
            return retirar;
        }

        private fun reset() {
            listaColores.value?.clear()
            secuenciaUser.value?.clear()
        }

        fun añadirSecuenciaUser(color: Int) {
            when (color) {
                1 -> secuenciaUser.value?.add(1)
                2 -> secuenciaUser.value?.add(2)
                3 -> secuenciaUser.value?.add(3)
                else -> secuenciaUser.value?.add(4)
            }
        }

        fun recogerSecuencia(): MutableList<Int> {
            return listaColores.value!!
        }

        fun mostrarSecuencia(listButton: List<Button>) {
            CoroutineScope(Dispatchers.Main).launch {
                for (colors in listaColores.value!!) {
                    listButton.get(colors-1).setPressed(true)
                    delay(1000)
                    listButton.get(colors-1).setPressed(false)
                }
            }
        }
    }




   /* private val TAG_LOG: String = "mensaje ViewModel"
    // array para el random
    val numbers = mutableListOf<Int>()

    // definimos la ronda actual para observar
    val ronda = MutableLiveData<MutableList<Int>>()
    val msjBoton = MutableLiveData<String>()

    // inicializamos variables cuando instanciamos
    init {
        ronda.value = numbers
        msjBoton.value ="Start"
    }

    /**
     * añadimos uno a la var ronda
     */
    fun sumarRonda() {
        // añadimos uno a la ronda
        // tenemos que chequear si es null
        // lo podemos hacer con un 'if'
        numbers.add(Random.nextInt(0,4))
        ronda.postValue(numbers)
        Log.d(TAG_LOG, "Array: "+numbers.toString())
    }

    /**
     * cambiamos mensaje con coroutinas
     */
    fun salidaLog() {
        CoroutineScope(Dispatchers.Main).launch {
            suspendFun("Start")
            // esperamos dos segundos y cambiamos el mensaje
            delay(2000)
            suspendFun("Stop")
        }
    }

    /**
     * funcion auxiliar que es llamada desde la coroutina
     */
    private fun suspendFun(msg: String) {
        msjBoton.value = msg
        Log.d(TAG_LOG, msg)
    }

    fun crearLista(){

    }*/
