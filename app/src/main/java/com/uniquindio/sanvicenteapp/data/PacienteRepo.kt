package com.uniquindio.sanvicenteapp.data
import androidx.lifecycle.LiveData


class PacienteRepo(private val pacienteDao: PacienteDao){

    fun addPaciente(paciente : Paciente){
        pacienteDao.addPaciente(paciente)
    }


}