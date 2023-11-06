package com.uniquindio.sanvicenteapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.uniquindio.sanvicenteapp.entities.Cita

@Dao
interface CitaDao {

    @Upsert
    suspend fun addCita(cita: Cita)

    @Query("SELECT * FROM Cita")
    fun getCitas(): LiveData<List<Cita>>

    @Query("SELECT * FROM Cita WHERE idPaciente = :id")
    fun getCitasPorIdPaciente(id: Int): LiveData<List<Cita>>
}