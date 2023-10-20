package com.uniquindio.sanvicenteapp.data

import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.uniquindio.sanvicenteapp.entities.EstadoCita
import com.uniquindio.sanvicenteapp.entities.EstadoCitaCitaRelation
import com.uniquindio.sanvicenteapp.entities.Medico
import com.uniquindio.sanvicenteapp.entities.MedicoCitaRelation
import kotlinx.coroutines.flow.Flow

interface EstadoCitaDao  {
    @Upsert
    fun addEstadoDeCita(estadoCita: EstadoCita)
    @Query("SELECT * FROM EstadoCita")
    fun getEstadosDeCitas(): Flow<List<Medico>>

    @Transaction
    @Query("SELECT * FROM EstadoCita")
    fun getEstadosDeCitaConCita(): List<EstadoCitaCitaRelation>
}