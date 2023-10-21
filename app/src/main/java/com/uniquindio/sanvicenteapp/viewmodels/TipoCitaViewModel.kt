package com.uniquindio.sanvicenteapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.uniquindio.sanvicenteapp.data.PacienteRepo
import com.uniquindio.sanvicenteapp.data.SanVicenteDatabase
import com.uniquindio.sanvicenteapp.data.TipoCitaRepo
import com.uniquindio.sanvicenteapp.entities.Paciente
import com.uniquindio.sanvicenteapp.entities.TipoCita

class TipoCitaViewModel(application: Application): AndroidViewModel(application) {

    val readALlTiposDeCita: LiveData<List<TipoCita>>
    private val repository: TipoCitaRepo

    init {
        val tipoCitaDao = SanVicenteDatabase.getDatabase(application).tipoCitaDao()
        repository = TipoCitaRepo(tipoCitaDao)
        readALlTiposDeCita = repository.readAllTiposCiita


    }
}