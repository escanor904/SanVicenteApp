package com.uniquindio.sanvicenteapp.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = TipoMedico::class, parentColumns = ["idTipoMedico"], childColumns = ["idTipo"], onDelete = ForeignKey.CASCADE)])
class TipoCita(

    @PrimaryKey(autoGenerate = true)
    val idTipoCita: Int,
    val idTipo: Int,
    val nombre: String,
    val descripcion: String,

)