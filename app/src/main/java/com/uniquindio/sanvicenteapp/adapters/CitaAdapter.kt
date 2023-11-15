package com.uniquindio.sanvicenteapp.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.uniquindio.sanvicenteapp.R
import com.uniquindio.sanvicenteapp.databinding.ItemListCitaBinding
import com.uniquindio.sanvicenteapp.entities.Cita

class CitaAdapter(private val dataSet: List<Cita>) : RecyclerView.Adapter<CitaAdapter.ViewHolder>() {


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list_cita, viewGroup,
            false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

     val item   = dataSet.get(position)
     viewHolder.enlazarItem(item)
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var binding = ItemListCitaBinding.bind(view)
        var contexto = view.context
        var butonCalcelarCita: Button = binding.buttonCancelarCita


        fun enlazarItem(c: Cita) {
            lateinit var tipoCita : String
            when (c.idTipoCita){

                200 -> tipoCita = "General"
                201 -> tipoCita = "Especialista"
                202 -> tipoCita = "Odontologica"
            }

            binding.textViewTipoCita.text = tipoCita
            binding.textViewDescripcion.text = "${c.motivoCita}"
            binding.textViewFechaCita.text = "${c.fechaAtencion}"
            binding.textViewHoraCita.text = "${c.hora}"

        }

    }


}
