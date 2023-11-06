package com.uniquindio.sanvicenteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class HomeActivity : AppCompatActivity() {

    private  var idUsuarioEnSesion : String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        idUsuarioEnSesion = intent.extras?.getString("IdPacienteEnSesion").orEmpty()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    fun lanzarRecervarCita(view: View){

        val lanzar = Intent(this, ReservarCitaActivity::class.java)
        lanzar.putExtra("IdPacienteEnSesion",idUsuarioEnSesion)
        startActivity(lanzar)
    }

    fun lanzarMisCitas(view: View){

        val lanzar = Intent(this, MisCitasActivity::class.java)
        lanzar.putExtra("IdPacienteEnSesion",idUsuarioEnSesion)
        startActivity(lanzar)
    }

    fun cerrarSesion(view: View){
        val lanzar = Intent(this, LoginActivity::class.java)
        startActivity(lanzar)

    }


}