package com.example.projetodispositivos

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projetodispositivos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa o View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recuperar os dados do SharedPreferences
        val sharedPreferences = getSharedPreferences("LoginPrefs", Context.MODE_PRIVATE)
        val savedLogin = sharedPreferences.getString("login", "")
        val savedPassword = sharedPreferences.getString("password", "")

        // Preencher os campos com os dados salvos
        binding.Login.setText(savedLogin)
        binding.Senha.setText(savedPassword)

        // Configurar evento de clique
        binding.btnEntrar.setOnClickListener {
            val login = binding.Login.text.toString()
            val password = binding.Senha.text.toString()

            // Verifica se o login e a senha são "admin"
            if (login == "admin" && password == "admin") {
                // Salvar login e senha no SharedPreferences
                val editor = sharedPreferences.edit()
                editor.putString("login", login)
                editor.putString("password", password)
                editor.apply()

                // Redireciona para a tela de ProdutoActivity
                val intent = Intent(this, ProdutoActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Exibe mensagem de erro
                Toast.makeText(this, "Login ou senha incorretos!", Toast.LENGTH_SHORT).show()
            }
        }

        // Configura o clique no texto "Esqueci minha senha"
        binding.EsqueciSenha.setOnClickListener {
            Toast.makeText(this, "Recuperação de senha não implementada!", Toast.LENGTH_SHORT).show()
        }
    }
}
