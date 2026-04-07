package com.example.vanapp.repository

import com.example.vanapp.model.Van
import com.example.vanapp.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VanRepository {

    fun buscarVans(callback: (List<Van>) -> Unit) {

        RetrofitClient.api.getUsers().enqueue(object : Callback<List<com.example.vanapp.model.User>> {

            override fun onResponse(
                call: Call<List<com.example.vanapp.model.User>>,
                response: Response<List<com.example.vanapp.model.User>>
            ) {
                val users = response.body() ?: emptyList()

                val vans = users.map {
                    Van(it.name, "Motorista X", "07:00")
                }

                callback(vans)
            }

            override fun onFailure(call: Call<List<com.example.vanapp.model.User>>, t: Throwable) {
                callback(emptyList())
            }
        })
    }
}
