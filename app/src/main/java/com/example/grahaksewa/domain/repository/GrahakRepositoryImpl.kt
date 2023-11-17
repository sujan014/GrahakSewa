package com.example.grahaksewa.domain.repository

import com.example.grahaksewa.domain.data.GrahakDao
import com.example.grahaksewa.domain.model.Grahak
import kotlinx.coroutines.flow.Flow

class GrahakRepositoryImpl(
    private val dao: GrahakDao
): GrahakRepository {
    override suspend fun insertGrahak(grahak: Grahak) {
        dao.insertGrahak(grahak)
    }

    override suspend fun deleteGrahak(grahak: Grahak) {
        dao.deleteGrahak(grahak)
    }

    override fun getAllGrahak(): Flow<List<Grahak>> {
        return dao.getAllGrahak()
    }

    override suspend fun getGrahakById(id: Int): Grahak? {
        return dao.getGrahakById(id=id)
    }

    override suspend fun deleteAll() {
        dao.deleteAll()
    }

    override suspend fun getAllGrahakList(): List<Grahak> {
        return dao.getAllGrahakList()
    }

}