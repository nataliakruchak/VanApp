package com.example.vanapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usuario = findViewById<EditText>(R.id.edtUsuario)
        val senha = findViewById<EditText>(R.id.edtSenha)
        val btnEntrar = findViewById<Button>(R.id.btnEntrar)
        val btnCadastrar = findViewById<Button>(R.id.btnCadastrar)

        btnEntrar.setOnClickListener {

            val user = usuario.text.toString()
            val pass = senha.text.toString()

            // 🔍 Verifica campos vazios
            if (user.isEmpty()) {
                usuario.error = "Digite o usuário"
                return@setOnClickListener
            }

            if (pass.isEmpty()) {
                senha.error = "Digite a senha"
                return@setOnClickListener
            }

            val prefs = getSharedPreferences("dados_login", MODE_PRIVATE)
            val usuarioSalvo = prefs.getString("usuario", null)
            val senhaSalva = prefs.getString("senha", null)

            if (user == usuarioSalvo && pass == senhaSalva) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("usuario", user)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Login inválido!", Toast.LENGTH_SHORT).show()
            }
        }

        // 🆕 CADASTRO
        btnCadastrar.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

    }
}
