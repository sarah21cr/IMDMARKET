package com.example.projetodispositivos

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.projetodispositivos.databinding.ActivityProdutoBinding

class ProdutoActivity : AppCompatActivity() {

    // Declaração do binding correspondente ao layout `activity_produto.xml`
    private lateinit var binding: ActivityProdutoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicialização do ViewBinding
        binding = ActivityProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)



        // Configuração dos botões
        binding.btnCadastrarProduto.setOnClickListener {
            val intent = Intent(this, CadastrarProdutoActivity::class.java)
            startActivity(intent)
        }

        binding.btnListarProduto.setOnClickListener {
            val intent = Intent(this, ListarProdutoActivity::class.java)
            startActivity(intent)
        }

        binding.btnAlterarProduto.setOnClickListener {
            val intent = Intent(this, AlterarProdutoActivity::class.java)
            startActivity(intent)
        }

        binding.btnDeletarProduto.setOnClickListener {
            val intent = Intent(this, ExclusaoProdutoActivity::class.java)
            startActivity(intent)
        }
    }
}
