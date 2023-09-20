package com.uniquindio.sanvicenteapp.entities

import androidx.room.Embedded
import androidx.room.Relation

data class MedicoYTipoMedico(
    /**
     * @Embedded: Esta anotación se usa en una propiedad de una entidad para indicar que debe
     * ser incrustada en la entidad actual.
     */
     //quiere decir que tipo medico"id" se debe incristar en la lista de medicos
    @Embedded
    val tipoMedico:TipoMedico,
    /**
     * @Relation: Esta anotación se utiliza para establecer una relación entre dos tablas en la base de datos
     */
    //entityColumn= el nombre de la columna que tiene el id de la clase incrustada
    //parentColumn= necesit el codigo donde va incrustar la llave foranea
    @Relation(parentColumn = "idTipoMedico", entityColumn = "idMedico")
    val medicos:List<Medico> = emptyList(),


)
