package com.uniquindio.sanvicenteapp.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey


@Entity(
    foreignKeys = [
        ForeignKey(entity = TipoMedico::class,
        parentColumns = ["idTipoMedico"],//etiqueta de la entidad propietaria
        childColumns = ["idTipo"], //etiqueta de la clase que hace referencia a la etiqueta propietaria
        onDelete = ForeignKey.CASCADE
        ),
    ]
)
data class Medico (

    @PrimaryKey
    val idMedico: Int,
    val idTipo: Int,
    val nombre: String,
    val apellido: String,
    val numeroTarjetaProfesional: String
)