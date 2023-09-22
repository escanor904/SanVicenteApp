package com.uniquindio.sanvicenteapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.uniquindio.sanvicenteapp.data.SanVicenteDatabase
import com.uniquindio.sanvicenteapp.data.TipoMedicoRepo
import com.uniquindio.sanvicenteapp.entities.TipoMedico
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class TipoMedicoViewModel(application: Application): AndroidViewModel(application) {
    private val repository: TipoMedicoRepo
    private val readAllData: Flow<List<TipoMedico>>

    init {
        val tipoMedicoDao = SanVicenteDatabase.getDatabase(application).tipoMedicoDao()
        repository = TipoMedicoRepo(tipoMedicoDao)
        readAllData = repository.leerTiposMedico()
    }

    fun addTipoMedico(tipoMedico: TipoMedico){
        viewModelScope.launch (Dispatchers.IO) {
            repository.addTipoMedico(tipoMedico)
        }
    }

    fun listarTiposMedico(): Flow<List<TipoMedico>>{
        return readAllData;
    }
}