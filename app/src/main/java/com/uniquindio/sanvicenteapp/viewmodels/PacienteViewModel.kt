package com.uniquindio.sanvicenteapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.uniquindio.sanvicenteapp.data.PacienteRepo
import com.uniquindio.sanvicenteapp.data.SanVicenteDatabase
import com.uniquindio.sanvicenteapp.entities.Paciente
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.coroutineContext

class PacienteViewModel(application: Application):AndroidViewModel (application){


    val readALlPacientes: LiveData<List<Paciente>>
    private val repository: PacienteRepo


    init {
        val pacienteDao = SanVicenteDatabase.getDatabase(application).pacienteDao()
        repository = PacienteRepo(pacienteDao)
        readALlPacientes=repository.readAllPacientes

    }

    fun addPaciente(paciente: Paciente){
        viewModelScope.launch (Dispatchers.IO) {
            repository.addPaciente(paciente)
        }
    }

    fun getPaciente(correo:String , clave:String):LiveData<Paciente>{
        val paciente:LiveData<Paciente> = repository.getPaciente(correo, clave)


        return paciente
    }




}