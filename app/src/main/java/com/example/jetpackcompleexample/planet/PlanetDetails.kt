package com.example.jetpackcompleexample

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.jetpackcompleexample.planet.model.Planet

@Composable
fun PlanetDetails(navController: NavHostController, planet: Planet) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            Image(
                painter = painterResource(id = planet.image),
                contentDescription = planet.description,
                modifier = Modifier
                    .width(100.dp)
                    .height(100.dp)
            )
            Column() {
                Text(
                    text = planet.name,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(start = 4.dp)
                )
                Text(
                    text = planet.description,
                    modifier = Modifier.padding(start = 4.dp)
                )

            }

        }
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            shape =  RoundedCornerShape(4.dp),
            onClick = {
                navController.popBackStack()
            }
        ) {
            Text(text = "Voltar")
        }
    }
}