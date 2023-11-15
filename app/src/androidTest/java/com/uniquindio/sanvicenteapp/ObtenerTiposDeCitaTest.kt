package com.uniquindio.sanvicenteapp

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.uniquindio.sanvicenteapp.data.SanVicenteDatabase
import com.uniquindio.sanvicenteapp.data.TipoCitaDao
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ObtenerTiposDeCitaTest {

    private lateinit var tipoCitaDao: TipoCitaDao
    private lateinit var testDatabase: SanVicenteDatabase

    @Before
    fun setup() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        testDatabase = SanVicenteDatabase.getDatabase(context)
        tipoCitaDao = testDatabase.tipoCitaDao()
    }

    @After
    fun closeDatabase() {
        testDatabase.close()
    }
    @Test
    fun obtenerTiposDeCitaTest() {
        // Context of the app under test.
        var lista = tipoCitaDao.getTiposDeCitasTest();

        assertEquals(2, lista.size)
    }
}