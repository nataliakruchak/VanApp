package com.example.vanapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vanapp.model.Van

class VanViewModel: ViewModel() {
    private val vans = MutableLiveData<List<Van>>()

    fun getVans(): LiveData<List<Van>> {
        vans.value = listOf(
            Van("Asa Sul → Empresa", "Carlos", "07:00"),
            Van("Ceilândia → Empresa", "João", "07:30"),
            Van("Taguatinga → Empresa", "Ana", "08:00")
        )
        return vans
    }
}