package com.uniquindio.sanvicenteapp.data

import com.uniquindio.sanvicenteapp.entities.Medico

class MedicoRepo(private val medicoDao: MedicoDao) {
    suspend fun addMedico(medico: Medico){
        medicoDao.addMedico(medico)
    }
}