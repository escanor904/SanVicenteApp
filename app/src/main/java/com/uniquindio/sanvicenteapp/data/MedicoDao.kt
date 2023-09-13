package com.uniquindio.sanvicenteapp.data

import androidx.room.Dao
import androidx.room.Upsert
import com.uniquindio.sanvicenteapp.entities.Medico

@Dao
interface MedicoDao {
    @Upsert
    fun addMedico(medico: Medico)
}