package com.example.monumentosgijon.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MonumentosDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMonumentos(monumentos:List<Monumento>)

    @Query("SELECT * FROM monumento_table")
    fun getMonumentos(): Flow<List<Monumento>>
}