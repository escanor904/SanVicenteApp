package com.uniquindio.sanvicenteapp.data

import com.uniquindio.sanvicenteapp.entities.Medico
import com.uniquindio.sanvicenteapp.entities.TipoMedicoMedicoRelation
import kotlinx.coroutines.flow.Flow

class TipoMedicoMedicoRelationRepo (private val tipoMedicoMedicoRelationDao: TipoMedicoMedicoRelationDao){
    fun getTipoMedicoMedicoAll(): Flow<List<Medico>>{
       return tipoMedicoMedicoRelationDao.getTipoMedicoMedicoAll();
    }
}