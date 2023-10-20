package com.uniquindio.sanvicenteapp

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uniquindio.sanvicenteapp.data.SanVicenteDatabase
import com.uniquindio.sanvicenteapp.entities.Paciente
import com.uniquindio.sanvicenteapp.viewmodels.MedicoViewModel
import com.uniquindio.sanvicenteapp.viewmodels.PacienteViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {


    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var textView_1: TextView
    private lateinit var paciendeViewModel: PacienteViewModel
    private lateinit var medicoViewModel: MedicoViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        //savedInstanceState: Bundle? guarda el estado de una actividad cuando se crea o reicia
        //Bundle es un tipo de contenedor que se utiliza para pasar datos entre componentes de Android, como actividades y fragmentos.
        // permite inicializar la actividad base
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //la clase R nos sirve como puente entre grafica y logica
        editText1 = findViewById<EditText>(R.id.editText_1)
        editText2 = findViewById<EditText>(R.id.editText_2)
        textView_1 = findViewById<TextView>(R.id.textView_1)


        // agrega un paciente a la base de datos
        paciendeViewModel = ViewModelProvider(this).get(PacienteViewModel::class.java)
        val paciente: Paciente = Paciente(0, "pepito", "perez", "cll24 #14-28", "3126789342")
        paciendeViewModel.addPaciente(paciente)
        //Toast.makeText(this, "paciente "+paciente.nombre+" agregado a la BBD", Toast.LENGTH_SHORT).show()





    }
        //Este método realiza la suma
    fun sumar(view: View) {

//            paciendeViewModel= ViewModelProvider(this).get(PacienteViewModel::class.java)
//            paciendeViewModel.readALlPacientes.observe( this, Observer {
//
//                    data ->
//                // data contiene el valor actual del LiveData
//                if (data != null) {
//                    // Haz algo con los datos, por ejemplo, actualiza una vista
//                    textView_1.setText(""+data.get(0).nombre)
//                }
//            }
//            )

            medicoViewModel = ViewModelProvider(this).get(MedicoViewModel::class.java)
            medicoViewModel.readAllCitasMedicos.observe(this, Observer {

                    data ->
                // data contiene el valor actual del LiveData
                if (data != null) {
                    // Haz algo con los datos, por ejemplo, actualiza una vista
                    textView_1.setText(""+data.get(0))
                }
            })






                       //val app = SanVicenteDatabase.getDatabase(application)
//
//            GlobalScope.launch(Dispatchers.IO) {
//
//                val medicos = app.medicoDao().getMedicosConCitas()
//                withContext(Dispatchers.Main){textView_1.setText(""+medicos.get(0))}
//            }

    }







}


