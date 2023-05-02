package com.example.monumentosgijon.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.monumentosgijon.data.Repository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Monumento::class], version = 1)
abstract class MonumentoDatabase: RoomDatabase() {
    abstract fun monumentosDao(): MonumentosDAO

    companion object {
        private var INSTANCE: MonumentoDatabase? = null

        fun getInstance(context: Context): MonumentoDatabase? {
            if (INSTANCE == null) {
                synchronized(MonumentoDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        MonumentoDatabase::class.java, "monumentos.db"
                    )
                        .addCallback(CALLBACK)
                        .build()
                }
            }
            return INSTANCE!!
        }

        fun destroyInstance() {
            INSTANCE = null
        }

        private val CALLBACK = object : Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                CoroutineScope(Dispatchers.IO).launch {
                    val monumentosDAO = INSTANCE?.monumentosDao()
                    val repository = Repository(monumentosDAO!!)
                    repository.updateMonumentosData().collect {
                    }
                }

            }
        }
    }
}