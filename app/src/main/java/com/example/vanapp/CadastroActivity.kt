package com.example.vanapp

import android.content.Context
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        val usuario = findViewById<EditText>(R.id.edtNovoUsuario)
        val senha = findViewById<EditText>(R.id.edtNovaSenha)
        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val email = findViewById<EditText>(R.id.edtEmail)
        val btnVoltar = findViewById<ImageButton>(R.id.btnVoltar)

        btnVoltar.setOnClickListener {
            finish()
        }

        btnSalvar.setOnClickListener {

            val mail = email.text.toString()
            val user = usuario.text.toString()
            val pass = senha.text.toString()

            if (mail.isEmpty()) {
                email.error = "Digite o email"
                return@setOnClickListener
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches()) {
                email.error = "Email inválido"
                return@setOnClickListener
            }

            if (user.isEmpty()) {
                usuario.error = "Digite o usuário"
                return@setOnClickListener
            }

            if (pass.isEmpty()) {
                senha.error = "Digite a senha"
                return@setOnClickListener
            }

            val prefs = getSharedPreferences("dados_login", Context.MODE_PRIVATE)
            val editor = prefs.edit()

            editor.putString("email", mail)
            editor.putString("usuario", user)
            editor.putString("senha", pass)
            editor.apply()

            Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}
