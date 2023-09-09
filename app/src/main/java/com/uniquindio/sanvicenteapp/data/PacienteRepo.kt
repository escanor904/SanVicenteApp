package com.uniquindio.sanvicenteapp.data
import androidx.lifecycle.LiveData

class PacienteRepo(private val pacienteDao: PacienteDao){

    val readAllData: LiveData<List<Paciente>> = pacienteDao.readALLDate()

    suspend fun addPaciente(paciente : Paciente){
        pacienteDao.addPaciente(paciente)
    }


}