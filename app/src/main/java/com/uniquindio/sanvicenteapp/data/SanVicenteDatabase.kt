package com.uniquindio.sanvicenteapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.uniquindio.sanvicenteapp.entities.Cita
import com.uniquindio.sanvicenteapp.entities.EstadoCita
import com.uniquindio.sanvicenteapp.entities.Medico
import com.uniquindio.sanvicenteapp.entities.Paciente
import com.uniquindio.sanvicenteapp.entities.TipoCita
import com.uniquindio.sanvicenteapp.entities.TipoMedico
import java.io.File

@Database(
    //especificamos las entidades que se van a crear en la base de datos
    entities = [Paciente::class, Medico::class, TipoMedico::class, TipoCita::class, Cita::class, EstadoCita::class ],
    version = 1,
    exportSchema = true
)
abstract class SanVicenteDatabase: RoomDatabase() {

    abstract fun pacienteDao(): PacienteDao
    abstract fun medicoDao(): MedicoDao
    abstract fun tipoMedicoDao(): TipoMedicoDao
    abstract fun tipoCitaDao():TipoCitaDao
    abstract fun citaDao():CitaDao
   /*
   companion objeto compañero que proporciona metodos estaticos para acceder a la base de datos
    */
    companion object{
       //volatile hace que la lectura y escritura sea hacia la memoria principal y no a la cache
        @Volatile
        //almacena una instancia de la base de datos
        private var INSTANCE: SanVicenteDatabase?=null

       //get database nos permite obtener una instancia de la base de datos
        fun getDatabase(context: Context): SanVicenteDatabase{
            val tempInstance = INSTANCE
           //verifica si ya hay una unstancia de la base de datos
            if(tempInstance != null){
                return tempInstance
            }
           //si no se utiliza syncronized para asegurarse de que solo se cree una instancia de la base de datos a la vez en hilos múltiples
            synchronized(this){
                //Room.databaseBuilder crear la instancia a la base de datos
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SanVicenteDatabase::class.java,
                    //"database/inicializar.db"
                    "san_vicente_database"
                )

                .createFromAsset("database/san_vicente_database.db")
                .build()
                INSTANCE= instance
                return instance

            }
        }
    }
}