package com.uniquindio.sanvicenteapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.uniquindio.sanvicenteapp.data.PacienteRepo
import com.uniquindio.sanvicenteapp.data.SanVicenteDatabase
import com.uniquindio.sanvicenteapp.data.Paciente
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.Flow

class PacienteViewModel(application: Application):AndroidViewModel (application){


    private val repository: PacienteRepo
    private val readAllData: Flow<List<Paciente>>

    init {
        val pacienteDao = SanVicenteDatabase.getDatabase(application).pacienteDao()
        repository = PacienteRepo(pacienteDao)
        readAllData= repository.leerPacientes()
    }

    fun addPaciente(paciente: Paciente){
        viewModelScope.launch (Dispatchers.IO) {
            repository.addPaciente(paciente)
        }

    }

    fun listarPacientes(): Flow<List<Paciente>> {
        return readAllData
    }
}