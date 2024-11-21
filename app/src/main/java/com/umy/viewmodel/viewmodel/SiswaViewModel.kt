package com.umy.viewmodel.viewmodel

import androidx.lifecycle.ViewModel
import com.umy.viewmodel.model.DataSiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SiswaViewModel : ViewModel() {

    //Request
    private val _statusUI = MutableStateFlow(DataSiswa())
    //Response
    val statusUI: StateFlow<DataSiswa> = _statusUI.asStateFlow()

    fun saveDataSiswa(ls: MutableList<String>) {
        _statusUI.update { statusSaatIni ->
            statusSaatIni.copy(
                nama = ls[0],
                gender = ls[1],
                alamat = ls[1],
                notelpon = ls[0],
            )
        }
    }
}