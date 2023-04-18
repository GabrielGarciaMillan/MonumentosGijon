package com.example.monumentosgijon.ui

import Monumento
import com.example.monumentosgijon.state.AppStatus

sealed class MonumentosUIState (val state: AppStatus) {
    data class Success (val datos: List<Monumento> ): MonumentosUIState(AppStatus.SUCCESS)
    data class Error (val message:String): MonumentosUIState(AppStatus.ERROR)
}