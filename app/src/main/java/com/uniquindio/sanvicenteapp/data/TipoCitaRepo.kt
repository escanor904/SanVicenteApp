package com.uniquindio.sanvicenteapp.data

import androidx.lifecycle.LiveData
import com.uniquindio.sanvicenteapp.entities.TipoCita


class TipoCitaRepo(private val tipoCitaDao: TipoCitaDao) {

    val readAllTiposCiita: LiveData<List<TipoCita>> = tipoCitaDao.getTiposDeCitas()

}