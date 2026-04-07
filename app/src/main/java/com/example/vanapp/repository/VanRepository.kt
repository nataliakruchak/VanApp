package com.example.vanapp.repository

import android.os.Handler
import android.os.Looper
import com.example.vanapp.model.Van

class VanRepository {

    fun buscarVans(callback: (List<Van>) -> Unit) {
        Handler(Looper.getMainLooper()).postDelayed({

            val lista = listOf(
                Van("Asa Sul → Empresa", "Carlos", "07:00"),
                Van("Ceilândia → Empresa", "João", "07:30"),
                Van("Taguatinga → Empresa", "Ana", "08:00")
            )

            callback(lista)

        }, 1500) // simula requisição (1.5s)
    }
}
