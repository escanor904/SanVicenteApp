package com.uniquindio.sanvicenteapp

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.uniquindio.sanvicenteapp.entities.Paciente
import com.uniquindio.sanvicenteapp.viewmodels.PacienteViewModel


class MainActivity : AppCompatActivity() {


    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var textView_1: TextView
    private lateinit var paciendeViewModel: PacienteViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        //savedInstanceState: Bundle? guarda el estado de una actividad cuando se crea o reicia
        //Bundle es un tipo de contenedor que se utiliza para pasar datos entre componentes de Android, como actividades y fragmentos.
        // permite inicializar la actividad base
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //la clase R nos sirve como puente entre grafica y logica
       // editText1 = findViewById<EditText>(R.id.editText_1)
        //editText2 = findViewById<EditText>(R.id.editText_2)
        //textView_1 = findViewById<TextView>(R.id.textView_1)



       // paciendeViewModel = ViewModelProvider(this).get(PacienteViewModel::class.java)
      //  val paciente: Paciente = Paciente(0,"pepito","perez")
       // paciendeViewModel.addPaciente(paciente)
       // Toast.makeText(this, "paciente agrregado al  BBD", Toast.LENGTH_SHORT).show()

//       var pacientesFlow:Flow<List<Paciente>> = paciendeViewModel.listarPacientes()
//        pacientesFlow.collect() { pacientes ->
//            // Procesar los datos aquí
//            for (paciente in pacientes) {
//                println("ID: ${paciente.id}, Nombre: ${paciente.nombre} ")
//            }
//        }
    }
    //Este método realiza la suma
    fun sumar( view: View){

        var a:Int = editText1.text.toString().toInt()
        var b:Int = editText2.text.toString().toInt()

        var resultado = a+b
        var suma:String = resultado.toString()
        textView_1.setText(suma)

    }

}