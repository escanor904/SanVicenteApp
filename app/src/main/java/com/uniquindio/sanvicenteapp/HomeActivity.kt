package com.uniquindio.sanvicenteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HomeActivity : AppCompatActivity() {
   // private val idUsuarioEnSesion: String? = intent.getStringExtra("IdPacienteEnSesion")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun lanzarRecervarCita(view: View){

        val lanzar = Intent(this, RecervarCitaActivity::class.java)
        //lanzar.putExtra("IdPacienteEnSesion",idUsuarioEnSesion)
        startActivity(lanzar)
    }
}