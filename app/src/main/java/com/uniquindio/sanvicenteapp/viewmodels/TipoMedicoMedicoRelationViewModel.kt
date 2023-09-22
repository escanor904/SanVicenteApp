package com.uniquindio.sanvicenteapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.uniquindio.sanvicenteapp.data.SanVicenteDatabase
import com.uniquindio.sanvicenteapp.data.TipoMedicoMedicoRelationDao
import com.uniquindio.sanvicenteapp.data.TipoMedicoMedicoRelationRepo
import com.uniquindio.sanvicenteapp.entities.Medico
import com.uniquindio.sanvicenteapp.entities.TipoMedicoMedicoRelation
import kotlinx.coroutines.flow.Flow

class TipoMedicoMedicoRelationViewModel(application: Application): AndroidViewModel(application) {
    private val repository: TipoMedicoMedicoRelationRepo
    private val readAllData: Flow<List<Medico>>

    init {
        val tipoMedicoMedicoRelationDao = SanVicenteDatabase.getDatabase(application).tipoMedicoMedicoRelationDao()
        repository = TipoMedicoMedicoRelationRepo(tipoMedicoMedicoRelationDao)
        readAllData = repository.getTipoMedicoMedicoAll()
    }
}