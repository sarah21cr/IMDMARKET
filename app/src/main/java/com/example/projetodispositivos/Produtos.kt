package com.example.projetodispositivos

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Produtos {
    private val listaProdutos = mutableListOf<Produto>()

    fun adicionarProduto(produto: Produto) {
        listaProdutos.add(produto)
    }

    fun salvarProdutos(context: Context) {
        val sharedPreferences = context.getSharedPreferences("produtos", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        editor.putString("lista_produtos", gson.toJson(listaProdutos))
        editor.apply()
    }

    fun carregarProdutos(context: Context): List<Produto> {
        val sharedPreferences = context.getSharedPreferences("produtos", Context.MODE_PRIVATE)
        val gson = Gson()
        val produtosString = sharedPreferences.getString("lista_produtos", null)
        return if (produtosString != null) {
            val type = object : TypeToken<List<Produto>>() {}.type
            gson.fromJson(produtosString, type)
        } else {
            emptyList()
        }
    }

    fun obterProdutos(): List<Produto> {
        return listaProdutos
    }
}
