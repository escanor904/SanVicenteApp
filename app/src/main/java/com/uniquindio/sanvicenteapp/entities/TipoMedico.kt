package com.uniquindio.sanvicenteapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class TipoMedico (
    @PrimaryKey(autoGenerate = true)
    val idTipoMedico:Int,
    val nombre:String,
    val descripcion:String,
){
}