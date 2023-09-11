package com.uniquindio.sanvicenteapp.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import com.uniquindio.sanvicenteapp.data.Paciente as Paciente

/*
En esta interface se ubican todas la operaciones de acceso a datos en la tabla paciente_table
 */
@Dao
interface PacienteDao {
    //@Insert: Esta anotación indica que el método se utiliza para realizar una operación de inserción en la base de datos.
    //onConflict = OnConflictStrategy.IGNORE si se intenta insertar un registro con el mismo id lo ignora y no hace nada
    @Upsert
    //se inserta si no existe y si existe lo actualiza a diferencia de insert que puede causar errores
    fun addPaciente(paciente: Paciente)


    @Query("SELECT * FROM paciente ")
    fun getPacientes(): Flow<List<Paciente>>
}