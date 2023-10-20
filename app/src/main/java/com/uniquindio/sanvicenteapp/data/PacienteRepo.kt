package com.uniquindio.sanvicenteapp.data

import androidx.lifecycle.LiveData
import com.uniquindio.sanvicenteapp.entities.Paciente
import kotlinx.coroutines.flow.Flow


class PacienteRepo(private val pacienteDao: PacienteDao){

    val readAllPacientes: LiveData<List<Paciente>> = pacienteDao.getPacientes()

    suspend fun addPaciente(paciente : Paciente){
        pacienteDao.addPaciente(paciente)
    }
    fun getPaciente(correo:String , clave:String): LiveData<Paciente?>{
        return pacienteDao.getPaciente(correo,clave)
    }





}