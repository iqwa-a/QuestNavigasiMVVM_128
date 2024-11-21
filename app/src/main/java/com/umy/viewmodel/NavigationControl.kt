package com.umy.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.umy.viewmodel.viewmodel.SiswaViewModel
import androidx.navigation.compose.composable
import com.umy.viewmodel.model.JenisKelamin
import com.umy.viewmodel.ui.view.FormulirView
import com.umy.viewmodel.ui.view.TampilDataView
import java.text.Normalizer.Form

enum class Halaman{
    FORMULIR,
    TAMPILDATA
}

@Composable
fun NavigationControl(
    modifier: Modifier = Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController()

) {
    val uiState by viewModel.statusUI.collectAsState()
    NavHost(
        navController = navHost,
        startDestination = Halaman.FORMULIR.name
    ) {
        composable(route = Halaman.FORMULIR.name) {
            val konteks = LocalContext.current
            FormulirView(
                listJK = JenisKelamin.JenisK.map { id -> konteks.getString(id) },
                onSubmitClicked = {
                    viewModel.saveDataSiswa(it)
                    navHost.navigate(Halaman.TAMPILDATA.name)
                }
            )
        }
        composable(route = Halaman.TAMPILDATA.name) {
            TampilDataView(
                uiState = uiState,
                onBackButton = { navHost.popBackStack() }
            )
        }
    }
}