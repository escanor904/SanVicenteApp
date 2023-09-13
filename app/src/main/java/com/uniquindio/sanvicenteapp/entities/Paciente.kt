package com.uniquindio.sanvicenteapp.entities
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Paciente(
    @PrimaryKey(autoGenerate = true)
    val id:Int=0,
    val nombre:String,
    val apellido:String
) {

}