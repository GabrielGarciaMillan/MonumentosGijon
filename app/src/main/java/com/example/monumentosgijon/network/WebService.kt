package com.example.monumentosgijon.network

import Monumento
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

//URL base
private val BASE_URL = "https://opendata.gijon.es/"

//Interfaz que da acceso al servicio
interface RestApiService {
    @GET("descargar.php?id=743&tipo=JSON")
    suspend fun getMonumentoInfo(): Monumento
}

//Objeto moshi
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

//Objeto retrofit
private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

//Objeto singleton del servicio
object RestApi {
    val retrofitService: RestApiService by lazy {
        retrofit.create(RestApiService::class.java)
    }
}