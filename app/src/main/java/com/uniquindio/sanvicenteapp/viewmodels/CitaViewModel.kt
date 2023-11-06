package com.uniquindio.sanvicenteapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.uniquindio.sanvicenteapp.data.CitaRepo
import com.uniquindio.sanvicenteapp.data.SanVicenteDatabase
import com.uniquindio.sanvicenteapp.entities.Cita
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CitaViewModel (application: Application):AndroidViewModel(application){


    val readAllCitas: LiveData<List<Cita>>
    private val repository: CitaRepo

    init {
        val citaDao = SanVicenteDatabase.getDatabase(application).citaDao()
        repository = CitaRepo(citaDao)
        readAllCitas = repository.readAllCitas
    }

    fun addCita(cita: Cita){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addCita(cita)
        }
    }

    fun getCitasPorIdPaciente(id: Int): LiveData<List<Cita>>{
        return repository.getCitasPorIdPaciente(id)
    }

}