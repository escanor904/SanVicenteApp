package com.uniquindio.sanvicenteapp.data

import androidx.room.Dao
import androidx.room.Query
import com.uniquindio.sanvicenteapp.entities.Medico
import kotlinx.coroutines.flow.Flow

@Dao
interface TipoMedicoMedicoRelationDao {
    @Query("SELECT * FROM Medico")
    fun getTipoMedicoMedicoAll(): Flow<List<Medico>>
}