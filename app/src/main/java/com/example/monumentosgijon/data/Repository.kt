package com.example.monumentosgijon.data

import Monumento
import com.example.monumentosgijon.model.MonumentoDatabase
import com.example.monumentosgijon.model.MonumentosDAO
import com.example.monumentosgijon.network.RestApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class Repository (private val monumentosDAO: MonumentosDAO){
    fun updateMonumentosData() =
        // Se crea un flujo
        flow {
            // Se realiza la petición al servicio
            try {
                // Respuesta correcta
                val monumentoStatus = RestApi.retrofitService.getMonumentosInfo()
                //Comprobar que tenga titulo

                //Añadir a la BD

                // Se emite el estado Succes y se incluyen los datos recibidos
                emit(ApiResult.Success(monumentoStatus))
            } catch (e: Exception) {
                // Error en la red
                // Se emite el estado de Error con el mensaje que lo explica
                emit(ApiResult.Error(e.toString()))
            }
            // El flujo se ejecuta en el hilo I/O
        }.flowOn(Dispatchers.IO)

    suspend fun insertMonumentos(monumentos: List<Monumento>) = monumentosDAO.insertMonumentos(monumentos)
}