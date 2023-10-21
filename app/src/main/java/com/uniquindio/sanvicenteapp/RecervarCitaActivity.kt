package com.uniquindio.sanvicenteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import androidx.cardview.widget.CardView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uniquindio.sanvicenteapp.viewmodels.PacienteViewModel
import com.uniquindio.sanvicenteapp.viewmodels.TipoCitaViewModel

class RecervarCitaActivity : AppCompatActivity() {
    private lateinit var spiner: Spinner
    private  lateinit var tipoCitaViewModel : TipoCitaViewModel
    private lateinit var cardView1: CardView
    private lateinit var cardView2: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recervar_cita)

        //se inicializa el viewmodel
        tipoCitaViewModel = ViewModelProvider(this).get(TipoCitaViewModel::class.java)

        //se inicializan los ocmponentes de la interfaz
        cardView1= findViewById<CardView>(R.id.cardView1)
        cardView2= findViewById<CardView>(R.id.cardView2)

        inicializarSpiner()







    }
    fun inicializarSpiner(){


        val listaTiposDeCitas: MutableList<String> = mutableListOf()
        tipoCitaViewModel.readALlTiposDeCita.observe(this, Observer {lista ->

            //recorre los tipos de citas que tenemos en la base de datos y los base en una lista
            if (lista != null) {
                // Recorre la lista y accede a cada elemento
                for (tipoCita in lista) {
                    // Hacer algo con cada elemento tipoCita
                    val nombre = tipoCita.nombre

                    listaTiposDeCitas.add(nombre)
                }
            }
        })

       val spiner = findViewById<Spinner>(R.id.spinerTipoCita)
       //val listaTiposDeCitas = listOf("General","Especialista","Pediatra")
       // este array me sirve para convertir cada dato de la lista a el tipo que necesito en este caso "
       val adaptador =ArrayAdapter(this,android.R.layout.simple_spinner_item,listaTiposDeCitas)
       spiner.adapter= adaptador

    }
    fun goCard2 (view: View){
        cardView1.visibility=View.GONE
        cardView2.visibility=View.VISIBLE
    }
}