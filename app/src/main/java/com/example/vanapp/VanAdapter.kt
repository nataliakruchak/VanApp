package com.example.vanapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.vanapp.model.Van

class VanAdapter(context: Context, private val vans: List<Van>) :
    ArrayAdapter<Van>(context, 0, vans) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.item_van, parent, false)

        val van = vans[position]

        val rota = view.findViewById<TextView>(R.id.txtRota)
        val motorista = view.findViewById<TextView>(R.id.txtMotorista)
        val horario = view.findViewById<TextView>(R.id.txtHorario)

        rota.text = van.rota
        motorista.text = "Motorista: ${van.motorista}"
        horario.text = "Horário: ${van.horario}"

        return view
    }
}
