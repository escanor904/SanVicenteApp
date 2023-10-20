package com.uniquindio.sanvicenteapp.entities

import androidx.room.Embedded
import androidx.room.Relation

data class PacienteCitaRelation (
    @Embedded
    val paciente: Paciente,  //Entidad principal
    @Relation(
        parentColumn = "id", //etiqueta de la llave primaria de la entidad principal
        entityColumn = "idPaciente" //etiqueta de la variable de que se encuentra en la entidad secundaria
    )
    val listaCitas: List<Cita> = emptyList()
)