package com.uniquindio.sanvicenteapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Medico (

    @PrimaryKey
    val idMedico: Int,
    val nombre: String,
    val apellido: String,
    val numeroTarjetarofesional: String
)