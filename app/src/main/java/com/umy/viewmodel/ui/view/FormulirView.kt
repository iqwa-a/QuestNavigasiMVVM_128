package com.umy.viewmodel.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//@Preview(showBackground = true)
@Composable
fun FormulirView(
    modifier: Modifier = Modifier,
    listJK: List<String>,
    onSubmitClicked: (MutableList<String>) -> Unit
    ) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var notelpon by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }

    val listData : MutableList<String> = mutableListOf(nama,gender,alamat,notelpon)
    Column(
        modifier = Modifier.fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = nama,
            onValueChange = { nama = it },
            label = {
                Text("Nama")
            },
            placeholder = {
                Text("Isi Nama Anda")
            },
            modifier = modifier.fillMaxWidth()
                .padding(5.dp)

        )
        Row (
            modifier = Modifier.fillMaxWidth()) {       //mengganti variabel modifier dengan Modifier
            listJK.forEach{ selectedGender ->
                Row (verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = gender == selectedGender,
                        onClick = {
                            gender = selectedGender
                        })
                }
                Text(text = selectedGender) }
        }
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            placeholder = { Text("Isi Email Anda") },
            modifier = Modifier     //mengganti variabel modifier dengan Modifier
                .fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )
        TextField(
            value = alamat,
            onValueChange = { alamat = it },
            label = { Text("Alamat") },
            placeholder = { Text("Isi Alamat Anda") },
            modifier = Modifier     //mengganti variabel modifier dengan Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )
        TextField(
            value = notelpon,
            onValueChange = { notelpon = it },
            label = { Text("Nomor Telepon") },
            placeholder = { Text("Isi Nomor Telepon Anda") },
            modifier = Modifier     //mengganti variabel modifier dengan Modifier
                .fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

        )
        Button(
            onClick = {
                onSubmitClicked(listData)
            }) {
            Text("Simpan")
        }
    }
}