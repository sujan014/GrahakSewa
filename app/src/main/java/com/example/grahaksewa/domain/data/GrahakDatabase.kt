package com.example.grahaksewa.domain.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.grahaksewa.domain.model.Grahak

@Database(
    entities = [Grahak::class],
    version = 1
)
abstract class GrahakDatabase : RoomDatabase() {
    abstract val dao: GrahakDao
}