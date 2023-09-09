package com.uniquindio.sanvicenteapp.entities
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="paciente_table")
data class Paciente(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val Nombre:String,
    val apellido:String
)