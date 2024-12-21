package com.example.projetodispositivos

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.BaseAdapter

class ProdutoAdapter(
    private val context: Context,
    private val produtos: List<Produto>
) : BaseAdapter() {

    override fun getCount(): Int = produtos.size

    override fun getItem(position: Int): Produto = produtos[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context)
            .inflate(android.R.layout.simple_list_item_2, parent, false)

        val produto = getItem(position)
        val text1 = view.findViewById<TextView>(android.R.id.text1)
        val text2 = view.findViewById<TextView>(android.R.id.text2)

        text1.text = produto.nome
        text2.text = produto.descricao

        return view
    }
}
