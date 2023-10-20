package com.uniquindio.sanvicenteapp.entities

import androidx.room.Embedded
import androidx.room.Relation

data class MedicoCitaRelation (
    @Embedded
    val medico: Medico,  //Entidad principal
    @Relation(
        parentColumn = "idMedico", //etiqueta de la llave primaria de la entidad principal
        entityColumn = "idMedico" //etiqueta de la variable de que se encuentra en la entidad secundaria
    )
    val listaCitas: List<Cita> = emptyList()
)