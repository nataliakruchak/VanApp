package com.example.vanapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.vanapp.model.Van
import com.example.vanapp.repository.VanRepository

class VanViewModel : ViewModel() {

    private val repository = VanRepository()

    private val vans = MutableLiveData<List<Van>>()

    fun getVans(): LiveData<List<Van>> = vans

    fun carregarVans() {
        repository.buscarVans { lista ->
            vans.value = lista
        }
    }
}
