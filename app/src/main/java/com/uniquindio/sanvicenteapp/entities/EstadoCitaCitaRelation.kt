package com.uniquindio.sanvicenteapp.entities

import androidx.room.Embedded
import androidx.room.Relation

class EstadoCitaCitaRelation  (
    @Embedded
    val estadoCita: EstadoCita,  //Entidad principal
    @Relation(
        parentColumn = "idEstadoCita", //etiqueta de la llave primaria de la entidad principal
        entityColumn = "idEstadoCita" //etiqueta de la variable de que se encuentra en la entidad secundaria
    )
    val listaCitas: List<Cita> = emptyList()
)