package com.uniquindio.sanvicenteapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.uniquindio.sanvicenteapp.data.PacienteRepo
import com.uniquindio.sanvicenteapp.data.SanVicenteDatabase
import com.uniquindio.sanvicenteapp.data.Paciente
import kotlinx.coroutines.launch

class PacienteViewModel(application: Application):AndroidViewModel (application){

   // private val readAllData: LiveData<List<Paciente>>
    private val repository: PacienteRepo

    init {
        val pacienteDao = SanVicenteDatabase.getDatabase(application).pacienteDao()
        repository = PacienteRepo(pacienteDao)
       // readAllData = repository.readAllData
    }

    fun addPaciente(paciente: Paciente){
        viewModelScope.launch {
            repository.addPaciente(paciente)
        }
    }

//    fun listarPacientes(): LiveData<List<Paciente>> {
//        return repository.readAllData
//    }
}