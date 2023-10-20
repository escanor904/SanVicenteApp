package com.uniquindio.sanvicenteapp.entities

import androidx.room.Embedded
import androidx.room.Relation

class TipoCitaCitaRelation  (
    @Embedded
    val tipoCita: TipoCita,  //Entidad principal
    @Relation(
        parentColumn = "idTipoCita", //etiqueta de la llave primaria de la entidad principal
        entityColumn = "idTipoCita" //etiqueta de la variable de que se encuentra en la entidad secundaria
    )
    val listaCitas: List<Cita> = emptyList()
)