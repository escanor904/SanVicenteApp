package com.uniquindio.sanvicenteapp.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = TipoMedico::class, parentColumns = ["idTipoMedico"], childColumns = ["idTipo"], onDelete = ForeignKey.CASCADE)])
data class Medico (

    @PrimaryKey
    val idMedico: Int,
    val idTipo: Int,
    val nombre: String,
    val apellido: String,
    val numeroTarjetaProfesional: String
)