package com.uniquindio.sanvicenteapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.uniquindio.sanvicenteapp.entities.TipoMedico
import com.uniquindio.sanvicenteapp.entities.TipoMedicoMedicoRelation
import kotlinx.coroutines.flow.Flow

@Dao
interface TipoMedicoDao {
    @Upsert
    fun addTipoMedico(tipoMedico: TipoMedico)

    @Query("SELECT * FROM TipoMedico")
    fun getTiposMedico(): LiveData<List<TipoMedico>>

    @Query("SELECT * FROM TipoMedico")
    suspend fun getTiposMedicoEstatico(): List<TipoMedico>

    @Transaction
    @Query("SELECT * FROM TipoMedico")
    fun getTipoCitaConMedicos(): List<TipoMedicoMedicoRelation>

}