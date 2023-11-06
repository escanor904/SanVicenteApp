package com.uniquindio.sanvicenteapp.entities

import androidx.room.Embedded
import androidx.room.Relation

data class TipoMedicoTipoCitaRelation(
    //lave foranea
    @Embedded
    //val tipoMedico: TipoMedico,
    val tipoCita: TipoCita,
    @Relation(
        parentColumn = "idTipoCita",//etiqueta de la llave primaria de la entidad principal
        entityColumn = "idTipo"  //etiqueta de la variable de que se encuentra en la entidad secundaria
    )
    val listaTipoMedicos: List<TipoMedico> = emptyList()
)