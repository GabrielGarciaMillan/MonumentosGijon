package com.example.monumentosgijon.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.monumentosgijon.data.ApiResult
import com.example.monumentosgijon.data.Repository.updateMonumentosData
import com.example.monumentosgijon.ui.MonumentosUIState
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class MonumentosViewModel : ViewModel() {

    private val _monumentosUIStateObservable = MutableLiveData<MonumentosUIState>()
    val monumentosUIStateObservable: LiveData<MonumentosUIState> get() = _monumentosUIStateObservable

    init {
        getMonumentosList()
    }
    fun getMonumentosList() {
        viewModelScope.launch {
            updateMonumentosData().map {
                when (it) {
                    is ApiResult.Success -> MonumentosUIState.Success(it.data!!)
                    is ApiResult.Error -> MonumentosUIState.Error("Error")
                }
            }.collect {
                _monumentosUIStateObservable.value = it
            }
        }
    }
}