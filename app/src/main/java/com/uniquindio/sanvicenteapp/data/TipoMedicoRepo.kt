package com.uniquindio.sanvicenteapp.data

import com.uniquindio.sanvicenteapp.entities.TipoMedico
import kotlinx.coroutines.flow.Flow

class TipoMedicoRepo(private val tipoMedicoDao: TipoMedicoDao) {

    suspend fun addTipoMedico(tipoMedico: TipoMedico){
        tipoMedicoDao.addTipoMedico(tipoMedico)
    }

    fun leerTiposMedico(): Flow<List<TipoMedico>>{
        return tipoMedicoDao.getTiposMedico()
    }
}