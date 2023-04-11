package com.example.monumentosgijon.ui

import Monumento
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.monumentosgijon.databinding.SimpleListItemBinding

class MonumentosViewHolder (val itemBinding: SimpleListItemBinding) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(datoMonumento: Monumento) {
        itemBinding.text1.text = datoMonumento.titulo
    }
}