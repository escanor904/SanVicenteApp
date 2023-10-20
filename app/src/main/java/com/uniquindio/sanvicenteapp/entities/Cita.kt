package com.uniquindio.sanvicenteapp.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    foreignKeys = [
        ForeignKey(entity = Paciente::class,
            parentColumns = ["id"],//etiqueta que pertenece a la entidad principal
            childColumns = ["idPaciente"],//etiqueta dentro de la clase
            onDelete = ForeignKey.CASCADE
        ),

        ForeignKey(entity = Medico::class,
            parentColumns = ["idMedico"],
            childColumns = ["idMedico"],
            onDelete = ForeignKey.CASCADE
        ),

        ForeignKey(entity = TipoCita::class,
            parentColumns = ["idTipoCita"],
            childColumns = ["idTipoCita"],
            onDelete = ForeignKey.CASCADE
        ),

        ForeignKey(entity = EstadoCita::class,
            parentColumns = ["idEstadoCita"],
            childColumns = ["idEstadoCita"],
            onDelete = ForeignKey.CASCADE
        ),
    ]
)
data class Cita(
    @PrimaryKey(autoGenerate = true)
    val idCita:Int=0,
    //Foreing Keys
    val idPaciente:Int,
    val idMedico:Int,
    val idTipoCita:Int,
    val idEstadoCita:Int,

    val fechaAtencion:String,
    val hora:String,
    val motivoCita:String,

)