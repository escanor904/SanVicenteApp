package com.uniquindio.sanvicenteapp.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.uniquindio.sanvicenteapp.entities.Medico
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicoDao {
    @Upsert
    fun addMedico(medico: Medico)
    @Query("SELECT * FROM Medico")
    fun getMedicos(): Flow<List<Medico>>
}