package com.uniquindio.sanvicenteapp.data

import com.uniquindio.sanvicenteapp.entities.Paciente
import kotlinx.coroutines.flow.Flow


class PacienteRepo(private val pacienteDao: PacienteDao){

    suspend fun addPaciente(paciente : Paciente){
        pacienteDao.addPaciente(paciente)
    }

    fun leerPacientes(): Flow<List<Paciente>> {
        return pacienteDao.getPacientes()
    }


}