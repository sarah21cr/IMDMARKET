package com.example.projetodispositivos

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projetodispositivos.databinding.ActivityCadastrarProdutoBinding

class CadastrarProdutoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastrarProdutoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa o binding
        binding = ActivityCadastrarProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Configura o botão "Salvar"
        binding.btnSalvar.setOnClickListener {
            val nomeProduto = binding.etNomeProduto.text.toString().trim()
            val descricaoProduto = binding.etDescricaoProduto.text.toString().trim()

            if (nomeProduto.isEmpty() || descricaoProduto.isEmpty()) {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_SHORT).show()
            } else {
                // Cria o objeto Produto
                val produto = Produto(nomeProduto, descricaoProduto)

                // Adiciona o produto à lista
                Produtos.adicionarProduto(produto)

                // Salva os produtos no armazenamento local
                Produtos.salvarProdutos(this)

                Toast.makeText(this, "Produto salvo com sucesso!", Toast.LENGTH_SHORT).show()

                // Vai para a tela de listagem
                startActivity(Intent(this, ListarProdutoActivity::class.java))
                finish()
            }
        }

        // Configura o botão "Limpar"
        binding.btnLimpar.setOnClickListener {
            binding.etNomeProduto.text.clear()
            binding.etDescricaoProduto.text.clear()
        }
    }
}
