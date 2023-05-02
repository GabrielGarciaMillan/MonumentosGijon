package com.example.monumentosgijon.ui


import Monumento
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.monumentosgijon.databinding.SimpleListItemBinding

class MonumentosListAdapter : ListAdapter<Monumento, MonumentosViewHolder>(Monumento.DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonumentosViewHolder {
        val itemBinding = SimpleListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MonumentosViewHolder(itemBinding.root)
    }

    override fun onBindViewHolder(holder: MonumentosViewHolder, position: Int) {
       holder.bind(this.getItem(position))
    }
}