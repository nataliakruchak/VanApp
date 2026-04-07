package com.example.vanapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.vanapp.databinding.ActivityDetalhesBinding

class DetalhesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 🔗 ligação com o layout
        binding = ActivityDetalhesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val rota = intent.getStringExtra("rota")
        val motorista = intent.getStringExtra("motorista")
        val horario = intent.getStringExtra("horario")

        // 🔙 botão voltar
        binding.btnVoltar.setOnClickListener {
            finish()
        }

        // 📄 dados
        binding.txtRota.text = rota
        binding.txtMotorista.text = "Motorista: $motorista"
        binding.txtHorario.text = "Horário: $horario"

        // ✅ confirmação
        binding.btnConfirmar.setOnClickListener {
            Toast.makeText(this, "Embarque confirmado!", Toast.LENGTH_SHORT).show()
        }
    }
}
