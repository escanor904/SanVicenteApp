package com.uniquindio.sanvicenteapp.data

import com.uniquindio.sanvicenteapp.entities.Medico
import kotlinx.coroutines.flow.Flow

class MedicoRepo(private val medicoDao: MedicoDao) {
    suspend fun addMedico(medico: Medico){
        medicoDao.addMedico(medico)
    }

    fun leerMedicos(): Flow<List<Medico>> {
        return medicoDao.getMedicos()
    }
}