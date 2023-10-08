package com.uniquindio.sanvicenteapp.entities

import androidx.room.Embedded
import androidx.room.Relation

data class TipoMedicoMedicoRelation(
    @Embedded val tipoMedico: TipoMedico,
    @Relation(
        parentColumn = "idTipoMedico",
        entityColumn = "idTipo"
    )
    val listaMedicos: List<Medico> = emptyList()
)