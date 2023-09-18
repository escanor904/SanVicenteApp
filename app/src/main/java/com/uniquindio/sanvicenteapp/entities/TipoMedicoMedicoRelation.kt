package com.uniquindio.sanvicenteapp.entities

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation

@Entity
data class TipoMedicoMedicoRelation(
    @Embedded val tipoMedico: TipoMedico,
    @Relation(
        parentColumn = "idTipoMedico",
        entityColumn = "idTipo"
    )
    val Medico: List<Medico>
)