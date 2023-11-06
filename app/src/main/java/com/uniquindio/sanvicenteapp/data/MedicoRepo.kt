package com.uniquindio.sanvicenteapp.data

import androidx.lifecycle.LiveData
import com.uniquindio.sanvicenteapp.entities.Cita
import com.uniquindio.sanvicenteapp.entities.Medico
import com.uniquindio.sanvicenteapp.entities.MedicoCitaRelation
import com.uniquindio.sanvicenteapp.entities.Paciente
import kotlinx.coroutines.flow.Flow

class MedicoRepo(private val medicoDao: MedicoDao) {

    val readAllMedicos: LiveData<List<Medico>> = medicoDao.getMedicos()
    val readAllCitasDeMedicos: LiveData<List<MedicoCitaRelation>> = medicoDao.getMedicosConCitas()
    val medicosConCitas: LiveData<List<MedicoCitaRelation>> = medicoDao.getMedicosConCitas()
    fun addMedico(medico: Medico){
        medicoDao.addMedico(medico)
    }

    suspend fun getMedicoPorId(id: Int): List<Cita>{
        return  medicoDao.getMedicoPorId(id)
    }











}