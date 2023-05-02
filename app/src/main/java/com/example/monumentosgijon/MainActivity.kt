package com.example.monumentosgijon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.monumentosgijon.databinding.ActivityMainBinding

import com.example.monumentosgijon.ui.MonumentosListAdapter
import com.example.monumentosgijon.ui.MonumentosUIState
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }



}