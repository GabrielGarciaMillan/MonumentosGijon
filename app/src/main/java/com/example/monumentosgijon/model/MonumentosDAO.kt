package com.example.monumentosgijon.model

import Monumento
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface MonumentosDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMonumentos(monumentos:List<Monumento>)

    @Query("SELECT titulo FROM course_table")
    fun getNames(): Flow<List<String>>
}