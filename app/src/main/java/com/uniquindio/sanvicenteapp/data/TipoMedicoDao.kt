package com.uniquindio.sanvicenteapp.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.uniquindio.sanvicenteapp.entities.TipoMedico
import kotlinx.coroutines.flow.Flow

@Dao
interface TipoMedicoDao {
    @Upsert
    fun addTipoMedico(tipoMedico: TipoMedico)

    @Query("SELECT * FROM TipoMedico")
    fun getTiposMedico(): Flow<List<TipoMedico>>
}