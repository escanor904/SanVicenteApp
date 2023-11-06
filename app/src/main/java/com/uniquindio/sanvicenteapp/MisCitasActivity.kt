package com.uniquindio.sanvicenteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uniquindio.sanvicenteapp.adapters.CitaAdapter
import com.uniquindio.sanvicenteapp.databinding.ActivityMainBinding
import com.uniquindio.sanvicenteapp.databinding.ActivityMisCitasBinding
import com.uniquindio.sanvicenteapp.entities.Cita
import com.uniquindio.sanvicenteapp.viewmodels.CitaViewModel
import com.uniquindio.sanvicenteapp.viewmodels.TipoCitaViewModel
import com.uniquindio.sanvicenteapp.viewmodels.TipoMedicoViewModel

class MisCitasActivity : AppCompatActivity() {

    private lateinit var citaViewModel: CitaViewModel
    private lateinit var binding: ActivityMisCitasBinding
    private lateinit var idUsuarioEnSesion : String
    private lateinit var listaCitas : List<Cita>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        idUsuarioEnSesion = intent.extras?.getString("IdPacienteEnSesion").orEmpty()
        binding = ActivityMisCitasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        citaViewModel = ViewModelProvider(this).get(CitaViewModel::class.java)

        citaViewModel.getCitasPorIdPaciente(idUsuarioEnSesion.toInt()).observe(this, Observer {
        listaCitas = it
        initRecyclerView()
        })




    }

    private fun initRecyclerView(){

        binding.recycler.apply {
            layoutManager = LinearLayoutManager(applicationContext)
        }

        binding.recycler.adapter = CitaAdapter(listaCitas)

    }
}