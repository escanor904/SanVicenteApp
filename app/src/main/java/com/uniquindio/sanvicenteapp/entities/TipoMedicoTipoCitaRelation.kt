package com.uniquindio.sanvicenteapp.entities

import androidx.room.Embedded
import androidx.room.Relation

data class TipoMedicoTipoCitaRelation(
    //lave foranea
    @Embedded
    val tipoMedico: TipoMedico,
    @Relation(
        parentColumn = "idTipoCita",
        entityColumn = "idTipo"
    )
    val listaTipoCitas: List<TipoCita> = emptyList()
)