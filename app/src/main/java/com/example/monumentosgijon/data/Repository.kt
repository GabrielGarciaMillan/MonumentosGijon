package com.example.monumentosgijon.data

import com.example.monumentosgijon.network.RestApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

object Repository {
    fun updateMonumentosData() =
        // Se crea un flujo
        flow {
            // Se realiza la petición al servicio
            try {
                // Respuesta correcta
                val monumentoStatus = RestApi.retrofitService.getMonumentoInfo()
                // Se emite el estado Succes y se incluyen los datos recibidos
                emit(ApiResult.Success(monumentoStatus))
            } catch (e: Exception) {
                // Error en la red
                // Se emite el estado de Error con el mensaje que lo explica
                emit(ApiResult.Error(e.toString()))
            }
            // El flujo se ejecuta en el hilo I/O
        }.flowOn(Dispatchers.IO)
}