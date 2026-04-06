package com.example.vanapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DetalhesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhes)

        val rota = intent.getStringExtra("rota")
        val motorista = intent.getStringExtra("motorista")
        val horario = intent.getStringExtra("horario")

        val txtRota = findViewById<TextView>(R.id.txtRota)
        val txtMotorista = findViewById<TextView>(R.id.txtMotorista)
        val txtHorario = findViewById<TextView>(R.id.txtHorario)
        val btnConfirmar = findViewById<Button>(R.id.btnConfirmar)
        val btnVoltar = findViewById<ImageButton>(R.id.btnVoltar)

        // 🔙 botão voltar
        btnVoltar.setOnClickListener {
            finish()
        }

        // 📄 dados
        txtRota.text = rota
        txtMotorista.text = "Motorista: $motorista"
        txtHorario.text = "Horário: $horario"

        // ✅ confirmação
        btnConfirmar.setOnClickListener {
            Toast.makeText(this, "Embarque confirmado!", Toast.LENGTH_SHORT).show()
        }
    }
}
