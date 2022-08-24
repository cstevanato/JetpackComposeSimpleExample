package com.example.jetpackcompleexample.crud.update

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.jetpackcompleexample.crud.data.entities.City

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun detailsComposable(
    viewModel: DetailsViewModel = hiltViewModel(),
    navController: NavController,
    city: City
) {

    val name: String by viewModel.nameCity.observeAsState(city.name.toString())
    val uf: String by viewModel.ufCity.observeAsState(city.uf.toString())
    val cep: String by viewModel.cepCity.observeAsState(city.cep.toString())

    viewModel.id = city.id!!.toInt()

    viewModel.onChangeCep(cep)
    viewModel.onChangeCity(name)
    viewModel.onChangeUf(uf)

    val status = viewModel.status.observeAsState()
    if (status.value == true) {
        navController.navigateUp()
        return
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            label = { Text(text = "Informe Cidade") },
            value = name,
            onValueChange = {
                viewModel.onChangeCity(it)
            })
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            label = { Text(text = "Informe Cep") },
            value = cep,
            onValueChange = {
                viewModel.onChangeCep(it)
            })
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            label = { Text(text = "Informe UF") },
            value = uf,
            onValueChange = {
                viewModel.onChangeUf(it)
            })

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            onClick = {
                viewModel.update()
            }) {
            Text(text = "Alterar")
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            onClick = {
                viewModel.remove()
            }) {
            Text(text = "Remover")
        }
    }
}