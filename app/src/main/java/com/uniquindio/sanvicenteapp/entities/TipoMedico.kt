package com.uniquindio.sanvicenteapp.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


//Entidad secundaria
@Entity(foreignKeys = [ForeignKey(entity = TipoCita::class, parentColumns = ["idTipoCita"], childColumns = ["idTipo"], onDelete = ForeignKey.CASCADE)])
data class TipoMedico(
    @PrimaryKey(autoGenerate = true)
    val idTipoMedico: Int,
    val idTipo: Int, //va a a ser el id del TipoCita
    val nombre: String,
    val descripcion: String

)