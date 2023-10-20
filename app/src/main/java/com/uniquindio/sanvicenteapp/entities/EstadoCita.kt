package com.uniquindio.sanvicenteapp.entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class EstadoCita (

    @PrimaryKey(autoGenerate = true)
    val idEstadoCita: Int,
    @NonNull
    val nombre: String,
    @NonNull
    val descripcion: String

    )