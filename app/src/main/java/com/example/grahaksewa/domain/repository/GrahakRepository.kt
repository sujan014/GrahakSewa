package com.example.grahaksewa.domain.repository

import com.example.grahaksewa.domain.model.Grahak
import kotlinx.coroutines.flow.Flow

interface GrahakRepository {
    suspend fun insertGrahak(grahak: Grahak)

    suspend fun deleteGrahak(grahak: Grahak)

    fun getAllGrahak(): Flow<List<Grahak>>

    suspend fun getGrahakById(id: Int): Grahak?

    suspend fun deleteAll()

    suspend fun getAllGrahakList(): List<Grahak>
}