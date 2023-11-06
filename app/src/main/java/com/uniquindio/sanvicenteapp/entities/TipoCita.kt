package com.uniquindio.sanvicenteapp.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


//entidad secundaria
@Entity
class TipoCita(

    @PrimaryKey(autoGenerate = true)
    val idTipoCita: Int,
    val nombre: String,
    val descripcion: String,

)