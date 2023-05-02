package com.example.monumentosgijon.data


import com.example.monumentosgijon.model.Monumento
import com.example.monumentosgijon.model.MonumentoDatabase
import com.example.monumentosgijon.model.MonumentosDAO
import com.example.monumentosgijon.network.RestApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class Repository (private val monumentosDAO: MonumentosDAO){
  suspend fun updateMonumentosData() =
        // Se crea un flujo
        flow {
            // Se realiza la petición al servicio
            try {
                // Respuesta correcta
                val monumentoStatus = RestApi.retrofitService.getMonumentosInfo()
                //Añadir a la BD
                insertMonumentos(monumentoStatus)
            } catch (e: Exception) {
                // Error en la red
                // Se emite el estado de Error con el mensaje que lo explica
                emit(ApiResult.Error(e.toString()))
            }
            // El flujo se ejecuta en el hilo I/O
        }.flowOn(Dispatchers.IO)

    suspend fun insertMonumentos(monumentos: List<Monumento>) = monumentosDAO.insertMonumentos(monumentos)

    fun getMonumentos() = monumentosDAO.getMonumentos()
}