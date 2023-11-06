package com.uniquindio.sanvicenteapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.uniquindio.sanvicenteapp.data.SanVicenteDatabase
import com.uniquindio.sanvicenteapp.data.TipoMedicoRepo
import com.uniquindio.sanvicenteapp.entities.TipoMedico
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TipoMedicoViewModel(application: Application): AndroidViewModel(application) {
    private val repository: TipoMedicoRepo
    val readAllTipoMedico: LiveData<List<TipoMedico>>


    init {
        val tipoMedicoDao = SanVicenteDatabase.getDatabase(application).tipoMedicoDao()
        repository = TipoMedicoRepo(tipoMedicoDao)
        readAllTipoMedico = repository.readAllTipoMedico
    }

    fun addTipoMedico(tipoMedico: TipoMedico){
        viewModelScope.launch (Dispatchers.IO) {
            repository.addTipoMedico(tipoMedico)
        }
    }

    fun getTiposMedicoEstatico(): List<TipoMedico>? {

        var tiposDemedico : List<TipoMedico>? = null

        viewModelScope.launch(Dispatchers.IO){
            tiposDemedico = withContext(Dispatchers.IO){repository.getTiposMedicoEstatico()}
        }

        return tiposDemedico
    }




}