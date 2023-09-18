package com.uniquindio.sanvicenteapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.uniquindio.sanvicenteapp.data.MedicoRepo
import com.uniquindio.sanvicenteapp.data.SanVicenteDatabase
import com.uniquindio.sanvicenteapp.entities.Medico
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MedicoViewModel(application: Application): AndroidViewModel(application) {
    private val repository: MedicoRepo
    private val readAllData: Flow<List<Medico>>

    init {
        val medicoDao = SanVicenteDatabase.getDatabase(application).medicoDao()
        repository = MedicoRepo(medicoDao)
        readAllData = repository.leerMedicos();
    }

    fun addMedico(medico: Medico){
        viewModelScope.launch (Dispatchers.IO) {
            repository.addMedico(medico)
        }
    }

    fun listarMedicos(): Flow<List<Medico>>{
        return readAllData
    }
}