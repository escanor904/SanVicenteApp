package com.uniquindio.sanvicenteapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.uniquindio.sanvicenteapp.data.MedicoRepo
import com.uniquindio.sanvicenteapp.data.SanVicenteDatabase
import com.uniquindio.sanvicenteapp.entities.Cita
import com.uniquindio.sanvicenteapp.entities.Medico
import com.uniquindio.sanvicenteapp.entities.MedicoCitaRelation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * para hacer consultas a la base de datos es importante implementar corrutinas, lo que hace que las
 * consultas se realicen en otro hilo y no en el principal de la aplicación
 *
 *
 * scoope= inidica el ambito de la corruntina
 *
 *        viewModelScope= se va a ejecutar mientra que el view model se este ejecutando
 *        GlobalScope= se ejecuta mientra la aplicacion este ejecutandose
 * launch= un constructor de corrutina, nos permite ejecutar la corrutina
 *
 * Dispacher=
 *          .IO = este se utiliza para tareas bloqueantes, espera una respuesta
 */
class MedicoViewModel(application: Application): AndroidViewModel(application) {
    private val repository: MedicoRepo
    val readAllMedicos: LiveData<List<Medico>>
    val readAllCitasMedicos: LiveData<List<MedicoCitaRelation>>
    val medicosConCitas:  LiveData<List<MedicoCitaRelation>>
    




    init {
        val medicoDao = SanVicenteDatabase.getDatabase(application).medicoDao()
        repository = MedicoRepo(medicoDao)
        readAllMedicos=repository.readAllMedicos
        readAllCitasMedicos= repository.readAllCitasDeMedicos
        medicosConCitas = repository.medicosConCitas



    }

    fun addMedico(medico: Medico){
        viewModelScope.launch (Dispatchers.Default) {
            repository.addMedico(medico)
        }
    }

    fun getMedicoPorId(id: Int):List<Cita> {

        var listaCitas :List<Cita> = emptyList()
        viewModelScope.launch(Dispatchers.Default) {
            listaCitas = withContext(Dispatchers.IO){repository.getMedicoPorId(id)}
        }

        return listaCitas
    }











}