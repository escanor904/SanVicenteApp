package com.uniquindio.sanvicenteapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

/*
En esta interface se ubican todas la operaciones de acceso a datos en la tabla paciente_table
 */
@Dao
interface PacienteDao {
    //@Insert: Esta anotación indica que el método se utiliza para realizar una operación de inserción en la base de datos.
    //onConflict = OnConflictStrategy.IGNORE si se intenta insertar un registro con el mismo id lo ignora y no hace nada
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    //las operaciones en la base de datos son lentas por ende tiene que llamarse desde un contexto suspendido para que no se afecte el hilo principal de la aplicación
    suspend fun addPaciente(paciente: Paciente)

    @Query("SELECT * FROM paciente_table ORDER BY id ASC")
    fun readALLDate():LiveData<List<Paciente>>
}