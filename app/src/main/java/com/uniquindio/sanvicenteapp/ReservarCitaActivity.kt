package com.uniquindio.sanvicenteapp

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.uniquindio.sanvicenteapp.databinding.ActivityMainBinding
import com.uniquindio.sanvicenteapp.entities.Cita
import com.uniquindio.sanvicenteapp.entities.Medico
import com.uniquindio.sanvicenteapp.entities.MedicoCitaRelation
import com.uniquindio.sanvicenteapp.entities.TipoMedico
import com.uniquindio.sanvicenteapp.viewmodels.CitaViewModel
import com.uniquindio.sanvicenteapp.viewmodels.MedicoViewModel
import com.uniquindio.sanvicenteapp.viewmodels.TipoCitaViewModel
import com.uniquindio.sanvicenteapp.viewmodels.TipoMedicoViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Calendar
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class ReservarCitaActivity : AppCompatActivity() {

    private  lateinit var tipoCitaViewModel : TipoCitaViewModel
    private lateinit var citaViewModel : CitaViewModel
    private lateinit var  medicoViewModel: MedicoViewModel
    private lateinit var  tipoMedicoViewModel: TipoMedicoViewModel
    private lateinit var cardView1: CardView
    private lateinit var cardView2: CardView
    private lateinit var editTextDescripcionCard1 : EditText
    private lateinit var editTextFechaCard1 : EditText
    private val selectCalendar = Calendar.getInstance()
    private var selectRadioButton: RadioButton? = null
    private lateinit var spinner: Spinner
    private lateinit var tiposDeMedico:  List<TipoMedico>
    private lateinit var citasConMedicos: List<MedicoCitaRelation>
    private lateinit var listaDeMedicos: List<Medico>
    private lateinit var idUsuarioEnSesion : String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recervar_cita)


        //usuario en sesion
        idUsuarioEnSesion = intent.extras?.getString("IdPacienteEnSesion").orEmpty()

        //se inicializan los view models
        tipoCitaViewModel = ViewModelProvider(this).get(TipoCitaViewModel::class.java)
        medicoViewModel = ViewModelProvider(this).get(MedicoViewModel::class.java)
        tipoMedicoViewModel = ViewModelProvider(this).get(TipoMedicoViewModel::class.java)
        citaViewModel = ViewModelProvider(this).get(CitaViewModel::class.java)


        //se inicializan los ocmponentes de la interfaz
        cardView1= findViewById<CardView>(R.id.cardView1)
        cardView2= findViewById<CardView>(R.id.cardView2)
        spinner = findViewById<Spinner>(R.id.spinerTipoCita)
        editTextDescripcionCard1 = findViewById<EditText>(R.id.editTextDescripcion)
        editTextFechaCard1 = findViewById<EditText>(R.id.editTextFecha)




        inicializarSpiner()


        //inicializamos los valores del live data

        tipoMedicoViewModel.readAllTipoMedico.observe(this,Observer{listTipoMedico ->
        tiposDeMedico = listTipoMedico

        medicoViewModel.medicosConCitas.observe(this,Observer{listaMC ->
            citasConMedicos = listaMC
        })

        medicoViewModel.readAllMedicos.observe(this,Observer{listaMed ->
           listaDeMedicos = listaMed
        })


       })






    }
    fun inicializarSpiner(){


        val listaTiposMedicos: MutableList<String> = mutableListOf()
        val lista = listOf<String>("General","Cardiologo","Dermatologo","Dentista General")
        tipoCitaViewModel.readALlTiposDeCita.observe(this, Observer {lista ->

            //recorre los tipos de citas que tenemos en la base de datos y los base en una lista
            if (lista != null) {
                // Recorre la lista y accede a cada elemento
                for (tipoCita in lista) {
                    // Hacer algo con cada elemento tipoCita
                    val nombre = tipoCita.nombre

                    listaTiposMedicos.add(nombre)
                }
            }
        })

       //val spiner = findViewById<Spinner>(R.id.spinerTipoCita)
       //val listaTiposDeCitas = listOf("General","Especialista","Pediatra")
       // este array me sirve para convertir cada dato de la lista a el tipo que necesito en este caso "
       val adaptador =ArrayAdapter(this,android.R.layout.simple_spinner_item,lista)
       spinner.adapter= adaptador

    }
    fun goCard2 (view: View){
        if (editTextDescripcionCard1.text.toString()=="" || editTextFechaCard1.text.toString() == "" || selectRadioButton?.text.toString()== null){
            showAlert()
        }else{
            cardView1.visibility=View.GONE
            cardView2.visibility=View.VISIBLE
            val textTipoCita  = findViewById<EditText>(R.id.textViewTipoCita)
            val textDescripcion  = findViewById<EditText>(R.id.textViewDescripcion2)
            val textFechaCita  = findViewById<EditText>(R.id.textViewFechaCita)
            val horaDeCita  = findViewById<EditText>(R.id.textViewHoraCita)

            textTipoCita.setText(spinner.selectedItem.toString())
            textDescripcion.setText(editTextDescripcionCard1.text.toString())
            textFechaCita.setText(editTextFechaCard1.text.toString())
            horaDeCita.setText(selectRadioButton?.text.toString())
        }




    }

    fun selectFecha (view: View?) {

        val fechaInterfaz= findViewById<EditText>(R.id.editTextFecha)
        val year = selectCalendar.get(Calendar.YEAR)
        val month = selectCalendar.get(Calendar.MONTH)
        val day = selectCalendar.get(Calendar.DAY_OF_MONTH)
        val listener =DatePickerDialog.OnDateSetListener { datePicker, y, m, d ->
            selectCalendar.set(y,m,d)
            fechaInterfaz.setText("$y-$m-$d")
            displayRadioGroup(fechaInterfaz.text.toString())
        }

        DatePickerDialog(this,listener,year,month,day).show()
    }

    fun confirmarCita (view: View) {

    if (editTextDescripcionCard1.text.toString()=="" || editTextFechaCard1.text.toString() == "" || selectRadioButton?.text.toString()== null){
            showAlert()
        }else{
        lateinit var cita : Cita
        when (spinner.selectedItem.toString()){
            "General" ->
                cita = Cita(
                    idCita = 0,
                    idPaciente = idUsuarioEnSesion.toInt(),
                    idMedico = 101,
                    idTipoCita = 200,
                    idEstadoCita = 601,
                    fechaAtencion = editTextFechaCard1.text.toString(),
                    hora = selectRadioButton?.text.toString(),
                    motivoCita = editTextDescripcionCard1.text.toString())

            "Cardiologo" ->
                cita = Cita(
                    idCita = 0,
                    idPaciente = idUsuarioEnSesion.toInt(),
                    idMedico = 103,
                    idTipoCita = 201,
                    idEstadoCita = 601,
                    fechaAtencion = editTextFechaCard1.text.toString(),
                    hora = selectRadioButton?.text.toString(),
                    motivoCita = editTextDescripcionCard1.text.toString())

            "Dermatologo" ->
                cita = Cita(
                    idCita = 0,
                    idPaciente = idUsuarioEnSesion.toInt(),
                    idMedico = 104,
                    idTipoCita = 201,
                    idEstadoCita = 601,
                    fechaAtencion = editTextFechaCard1.text.toString(),
                    hora = selectRadioButton?.text.toString(),
                    motivoCita = editTextDescripcionCard1.text.toString())

            "Dentista General" ->
                cita = Cita(
                    idCita = 0,
                    idPaciente = idUsuarioEnSesion.toInt(),
                    idMedico = 105,
                    idTipoCita = 202,
                    idEstadoCita = 601,
                    fechaAtencion = editTextFechaCard1.text.toString(),
                    hora = selectRadioButton?.text.toString(),
                    motivoCita = editTextDescripcionCard1.text.toString())

        }

        citaViewModel.addCita(cita)
        val toast = Toast.makeText(this, "Cita agendada con exito", Toast.LENGTH_SHORT)
        toast.show()
        val lanzar = Intent(this, HomeActivity::class.java)
        startActivity(lanzar)
    }




    }

    private fun showAlert() {

        val builder: androidx.appcompat.app.AlertDialog.Builder = androidx.appcompat.app.AlertDialog.Builder(this)
        builder.setTitle("error en el agendamiento")
        builder.setMessage("se necesitan todos los datos para agendar la cita")
        builder.setPositiveButton("aceptar",null)

        val dialog: androidx.appcompat.app.AlertDialog = builder.create()
        dialog.show()


    }

    private fun displayRadioGroup(fecha: String){
        val radioGroupLeft = findViewById<LinearLayout>(R.id.radioGroupCard1_izq)
        val radioGroupRight= findViewById<LinearLayout>(R.id.radioGroupCard1_der)

        radioGroupLeft.removeAllViews()
        radioGroupRight.removeAllViews()

        selectRadioButton = null
        var goToLeft = true
        val tipomedico: String = spinner.selectedItem.toString()
        // se va a buscar horarios segun la disponibilidad de cada medico

        //var hours: List<String>? = emptyList()


        //hours = encontrarHorarios(fecha, obtenerIdDeTipoMedico(tipomedico))


        val hours = arrayOf("08:00 AM","08:30 AM","09:00 AM","09:30 AM","10:00 AM","10:30 AM","11:00 AM","11:30 AM","12:00 AM","02:00 PM","02:30 PM","03:00 PM","03:30 PM","04:00 AM","04:30 AM")
        hours?.forEach {
            val radioButton = RadioButton(this)
            radioButton.id = View.generateViewId()
            radioButton.text = it

            radioButton.setOnClickListener {view ->
                selectRadioButton?.isChecked = false
                selectRadioButton = view as RadioButton?
                selectRadioButton?.isChecked = true

            }


            if (goToLeft)
                radioGroupLeft.addView(radioButton)
            else
                radioGroupRight.addView(radioButton)

            goToLeft =! goToLeft
        }


    }



    fun encontrarHorarios(fecha: String,idTipoMedico: Int ):List<String>?{
        var horasDisponibles: List<String> = emptyList()



        for (medico in listaDeMedicos){
            if (medico.idTipo == idTipoMedico){
                //encuentro el me
                val listaCitasDeMedico : List<Cita> = medicoViewModel.getMedicoPorId(medico.idMedico)
                if (listaCitasDeMedico.size!= 14){
                    horasDisponibles=disponibilidadDeHora(listaCitasDeMedico)
                    break
                }
                //necesito generar la consulta para buscar la lista de las citas dado el id de un medico
            }
        }

        return horasDisponibles
    }



    private fun disponibilidadDeHora(listaDeCitas: List<Cita>):List<String>{
        var horasActuales: MutableList<String> = mutableListOf()
        var horasDisponibles: List<String> = emptyList()

        for (cita in listaDeCitas){
              horasActuales.add(cita.hora)
        }

        horasDisponibles=encontrarHorasDisponibles(horasActuales)

        return horasDisponibles

    }
    private fun encontrarHorasDisponibles(listaHorasActuales: List<String>):List<String>{
        var listaHoraria: List<String>? = listOf("08:00 AM","08:30 AM","09:00 AM","09:30 AM","10:00 AM","10:30 AM","11:00 AM","11:30 AM","02:00 PM","02:30 PM","03:00 PM","03:30 PM","04:00 PM","04:30 PM")
        var horasDisponibles: MutableList<String> = mutableListOf()
        var ban: Boolean = false

        if (listaHoraria != null) {
            for (horaLH in listaHoraria){
                for (horaLHA in listaHorasActuales){
                    //reviso que la hora no este en las horas en las citas actuales
                    if (horaLH == horaLHA){
                       ban =true
                       break
                    }
                }
                if (ban!=true){
                    horasDisponibles.add(horaLH)
                }
                ban=false
            }
        }

        return horasDisponibles
    }
    fun obtenerIdDeTipoMedico(nombre: String):Int {
        var codigo: Int = 0



            for (tipo in tiposDeMedico){
                if (tipo.nombre == nombre){
                    codigo=tipo.idTipoMedico
                    break
                }else
                    codigo=100
            }




        return codigo
    }

    override fun onBackPressed() {

        cardView1= findViewById<CardView>(R.id.cardView1)
        cardView2= findViewById<CardView>(R.id.cardView2)

        if (cardView2.visibility==View.VISIBLE){
            cardView2.visibility= View.GONE
            cardView1.visibility= View.VISIBLE
        }else{
            if (cardView1.visibility== View.VISIBLE){
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Esta seguro que desea salir?")
                builder.setMessage("Si abandonas el registro, los datos que habia ingresado se perderan")
                builder.setPositiveButton("Salir"){_,_ ->
                    finish()
                }
                builder.setNegativeButton("Continuar"){dialog,_ ->
                    dialog.dismiss()
                }

                val dialog = builder.create()
                dialog.show()
            }

        }

    }
}