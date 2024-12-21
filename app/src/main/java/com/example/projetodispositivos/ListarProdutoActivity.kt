package com.example.projetodispositivos

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.projetodispositivos.databinding.ActivityListarProdutoBinding

class ListarProdutoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListarProdutoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configura o layout com ViewBinding
        binding = ActivityListarProdutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Carregar a lista de produtos
        carregarProdutosNaLista()

        // Configurar botão "Voltar"
        binding.deletar2.setOnClickListener {
            finish() // Fecha a tela atual e volta para a anterior
        }
    }

    private fun carregarProdutosNaLista() {
        // Obtém a lista de produtos armazenados
        val produtos = Produtos.carregarProdutos(this)

        // Transforma os produtos em uma lista de strings formatadas para exibição
        val produtosString = produtos.map { "Nome: ${it.nome}\nDescrição: ${it.descricao}" }

        // Configura o ArrayAdapter para o ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, produtosString)
        binding.listView.adapter = adapter // Referência correta do ListView
    }
}
