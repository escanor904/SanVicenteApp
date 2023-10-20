package com.uniquindio.sanvicenteapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.uniquindio.sanvicenteapp.entities.MedicoCitaRelation
import com.uniquindio.sanvicenteapp.entities.Paciente
import com.uniquindio.sanvicenteapp.entities.PacienteCitaRelation
import kotlinx.coroutines.flow.Flow

/*
En esta interface se ubican todas la operaciones de acceso a datos en la tabla paciente_table
 */
@Dao
interface PacienteDao {
    //@Insert: Esta anotación indica que el método se utiliza para realizar una operación de inserción en la base de datos.
    //onConflict = OnConflictStrategy.IGNORE si se intenta insertar un registro con el mismo id lo ignora y no hace nada
    @Upsert
    //se inserta si no existe y si existe lo actualiza a diferencia de insert que puede causar errores
    suspend  fun addPaciente(paciente: Paciente)


    @Query("SELECT * FROM Paciente ")
    fun getPacientes(): LiveData<List<Paciente>>

    @Transaction
    @Query("SELECT * FROM Paciente")
    fun getPacienteConCitas(): List<PacienteCitaRelation>
}