package com.uniquindio.sanvicenteapp.data

import androidx.lifecycle.LiveData
import com.uniquindio.sanvicenteapp.entities.TipoMedico
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class TipoMedicoRepo(private val tipoMedicoDao: TipoMedicoDao) {

    val readAllTipoMedico: LiveData<List<TipoMedico>> = tipoMedicoDao.getTiposMedico()

    fun addTipoMedico(tipoMedico: TipoMedico){
        tipoMedicoDao.addTipoMedico(tipoMedico)
    }

    suspend fun getTiposMedicoEstatico() :List<TipoMedico>? {
        return withContext(Dispatchers.IO){
            getTiposMedicoEstatico()
        }

    }

}