package com.uniquindio.sanvicenteapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.uniquindio.sanvicenteapp.entities.Medico
import com.uniquindio.sanvicenteapp.entities.MedicoCitaRelation
import com.uniquindio.sanvicenteapp.entities.TipoCita
import com.uniquindio.sanvicenteapp.entities.TipoCitaCitaRelation
import kotlinx.coroutines.flow.Flow

@Dao
interface TipoCitaDao {
    @Upsert
    fun addTipoCita(tipoCita: TipoCita)
    @Query("SELECT * FROM TipoCita")
    fun getTiposDeCitas(): LiveData<List<TipoCita>>

    //nos permite obtener las lista de la relación
    @Transaction
    @Query("SELECT * FROM TipoCita")
    fun getTipoCitaConCitas(): LiveData<TipoCitaCitaRelation>

}