package com.uniquindio.sanvicenteapp.data
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="paciente_table")
data class Paciente(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val nombre:String,
    val apellido:String
) {

}