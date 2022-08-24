package com.example.jetpackcompleexample.crud.register

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterActivity(
    viewModel: RegisterViewModel = hiltViewModel(),
    navController: NavController
) {

    val name = viewModel.nameState.value
    val cep = viewModel.cepState.value
    val uf = viewModel.ufState.value


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
                viewModel.onChangeName(it)
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
                viewModel.register()
            }) {
            Text(text = "Cadastrar")
        }

        Spacer(modifier = Modifier.height(10.dp))
    }

}