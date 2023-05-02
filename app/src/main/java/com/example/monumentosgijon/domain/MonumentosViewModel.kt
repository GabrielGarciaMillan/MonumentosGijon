package com.example.monumentosgijon.domain
import androidx.lifecycle.*

import com.example.monumentosgijon.data.Repository
import com.example.monumentosgijon.model.Monumento


class MonumentoViewModel(val repository: Repository): ViewModel() {

    val monumentos: LiveData<List<Monumento>> = repository.getMonumentos().asLiveData()

}

class MonumentoViewModelFactory(private val repository: Repository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MonumentoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MonumentoViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}