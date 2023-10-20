package com.uniquindio.sanvicenteapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.uniquindio.sanvicenteapp.data.SanVicenteDatabase
import com.uniquindio.sanvicenteapp.databinding.ActivityMainBinding
import com.uniquindio.sanvicenteapp.entities.Paciente
import com.uniquindio.sanvicenteapp.viewmodels.PacienteViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginActivity : AppCompatActivity() {
    private lateinit var editTextEmail: EditText
    private lateinit var editTextClave: EditText
    private lateinit var binding: ActivityMainBinding
    private lateinit var paciendeViewModel: PacienteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        editTextEmail = findViewById<EditText>(R.id.editTextEmail)
        editTextClave = findViewById<EditText>(R.id.editTextPassword)

        paciendeViewModel = ViewModelProvider(this).get(PacienteViewModel::class.java)
        val paciente: Paciente = Paciente(
            0,
            "pepito",
            "perez",
            "cll24 #14-28",
            "3126789342",
            "pepito@gmail.com",
            "pepito123"
        )
        paciendeViewModel.addPaciente(paciente)

    }

    fun ingresar(view: View) {

        // Observa el LiveData
        paciendeViewModel.getPaciente(editTextEmail.text.toString(),editTextClave.text.toString()).observe(this, Observer { paciente ->
            // El paciente es el objeto emitido por el LiveData
            if (paciente != null) {
                // Hacer algo con el paciente
                val lanzar =Intent(this, HomeActivity::class.java)
                startActivity(lanzar)
            } else {
                // Manejar el caso en el que el LiveData emite un valor nulo
                //editTextEmail.setText(editTextClave.text.toString())
                showAlert()
            }
        })


    }

    private fun showAlert() {

        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setTitle("error de autenticación")
        builder.setMessage("usuario o contraseña incorrectos")
        builder.setPositiveButton("aceptar",null)

        val dialog: AlertDialog = builder.create()
        dialog.show()


    }


}