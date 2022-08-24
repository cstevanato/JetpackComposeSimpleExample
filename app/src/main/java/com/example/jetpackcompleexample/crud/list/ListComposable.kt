package com.example.jetpackcompleexample.crud.list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.jetpackcompleexample.crud.data.entities.City

@Composable
fun ListComposable(
    viewModel: ListViewModel = hiltViewModel(),
    navController: NavController,
    verticalArrangement: Arrangement.HorizontalOrVertical,
    contentPadding: PaddingValues
) {
    val cities by viewModel.cities.observeAsState(listOf())

    LazyColumn(
        verticalArrangement = verticalArrangement,
        contentPadding = contentPadding
    ) {
        itemsIndexed(cities) { _, item ->
            cityCard(navController = navController, city = item)
        }
    }
}

@Composable
fun cityCard(navController: NavController, city: City) {
    val _city = city.name ?: ""
    val _uf = city.uf ?: ""
    val _cep = city.cep ?: ""
    Card(
        elevation = CardDefaults.elevatedCardElevation(4.dp),
        shape = RoundedCornerShape(4.dp),
        border = BorderStroke(2.dp, color = Color.Blue),
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                navController.currentBackStackEntry?.savedStateHandle?.apply {
                    set("city", city)
                }
                navController.navigate("detailsScreen")
            }
    ) {
        Column() {
            Text(text = "Cidade: $_city")
            Text(text = "Uf: $_uf")
            Text(text = "Cep: $_cep")
        }
    }
}