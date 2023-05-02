package com.example.monumentosgijon.ui

import  com.example.monumentosgijon.model.Monumento
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.monumentosgijon.databinding.SimpleListItemBinding

class MonumentosViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView) {

    val itemBinding = SimpleListItemBinding.bind(itemView)

    fun bind(datoMonumento: Monumento) {
        itemBinding.text1.text = datoMonumento.titulo
    }
}