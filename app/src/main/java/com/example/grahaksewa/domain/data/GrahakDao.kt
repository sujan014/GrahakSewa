package com.example.grahaksewa.domain.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.grahaksewa.domain.model.Grahak
import kotlinx.coroutines.flow.Flow

//Responsible for providing us with methods and communicates with database
// @Query enables us to write raw SQL statement to access database
@Dao
interface GrahakDao {
    @Query("SELECT * FROM Grahak")
    fun getAllGrahak(): Flow<List<Grahak>>

    @Query("SELECT * FROM Grahak WHERE id = :id")
    suspend fun getGrahakById(id: Int): Grahak?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGrahak(grahak: Grahak)

    @Delete
    suspend fun deleteGrahak(grahak: Grahak)

    @Query("DELETE FROM grahak")
    suspend fun deleteAll()

    @Query("SELECT * FROM Grahak")
    suspend fun getAllGrahakList(): List<Grahak>
}