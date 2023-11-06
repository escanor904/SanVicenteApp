package com.uniquindio.sanvicenteapp.data

import androidx.lifecycle.LiveData
import com.uniquindio.sanvicenteapp.entities.Cita

class CitaRepo (private val citaDao: CitaDao) {

    val readAllCitas: LiveData<List<Cita>> = citaDao.getCitas()

    suspend fun addCita( cita: Cita){
        citaDao.addCita(cita)
    }

    fun getCitasPorIdPaciente(id: Int): LiveData<List<Cita>>{
        return  citaDao.getCitasPorIdPaciente(id)
    }
}