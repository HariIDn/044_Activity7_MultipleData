package com.example.act7

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Customerpage(
    onSubmitCLicked: (MutableList<String>) -> Unit,
    onCancelButtonClicked: () -> Unit
){
    var name by rememberSaveable{ mutableStateOf("") }
    var noTelp by rememberSaveable{ mutableStateOf("") }
    var alamat by rememberSaveable { mutableStateOf("") }
    val Datalist: MutableList<String> = mutableListOf(name, noTelp, alamat)
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Text(text = "Data Pelanggan")
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)))
        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            label = { Text(text = "Nama") })
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)))
        OutlinedTextField(
            value = noTelp,
            onValueChange = {noTelp = it},
            label = { Text(text = "Nomor Telepon") })
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small)))
        OutlinedTextField(
            value = alamat,
            onValueChange = {alamat = it},
            label = { Text(text = "Alamat") })
        Spacer(modifier = Modifier.padding(10.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_small))
                .weight(1f, false),
            horizontalArrangement =
            Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom
        ) {
            OutlinedButton(onClick = onCancelButtonClicked,
                modifier = Modifier.weight(1f)) {
                Text(text = stringResource(id = R.string.cncl))
            }
            Button(onClick = { onSubmitCLicked(Datalist) },
                modifier = Modifier.weight(1f),
                enabled = name.isNotEmpty() && noTelp.isNotEmpty() && noTelp.isNotEmpty()) {
                Text(stringResource(id = R.string.submit_button))
            }

        }
    }
}