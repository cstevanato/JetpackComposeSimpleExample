package com.example.jetpackcompleexample.retrofit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.jetpackcompleexample.retrofit.response.Digimon

@Composable
fun DigimonComposable(viewModel: DigimonLIstViewModel = hiltViewModel()) {

    LazyColumn() {
        itemsIndexed(viewModel.digimonList.value) { _, item ->
            showDigimon(digimon = item)
        }
    }
}

@Composable
fun showDigimon(digimon: Digimon) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Image(
            painter = rememberImagePainter(digimon.img), contentDescription = "",
            modifier = Modifier.height(80.dp)
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = digimon.name,
                modifier = Modifier.fillMaxWidth(),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
    }
}