package com.uniquindio.sanvicenteapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.uniquindio.sanvicenteapp.entities.Cita
import com.uniquindio.sanvicenteapp.entities.Medico
import com.uniquindio.sanvicenteapp.entities.MedicoCitaRelation
import com.uniquindio.sanvicenteapp.entities.TipoMedicoMedicoRelation
import kotlinx.coroutines.flow.Flow

@Dao
interface MedicoDao {
    @Upsert
    fun addMedico(medico: Medico)
    @Query("SELECT * FROM Medico")
    fun getMedicos(): LiveData<List<Medico>>


    //lista de citas de de cada médico
    @Transaction
    @Query("SELECT * FROM Medico")
    fun getMedicosConCitas(): LiveData<List<MedicoCitaRelation>>

    @Query("SELECT * FROM Cita WHERE idMedico = :id")
    suspend fun getMedicoPorId(id: Int): List<Cita>
}