package com.example.monumentosgijon.ui


import com.example.monumentosgijon.model.Monumento
import com.example.monumentosgijon.state.AppStatus

sealed class MonumentosUIState (val state: AppStatus) {
    data class Success (val datos: List<Monumento> ): MonumentosUIState(AppStatus.SUCCESS)
    data class Error (val message:String): MonumentosUIState(AppStatus.ERROR)
}