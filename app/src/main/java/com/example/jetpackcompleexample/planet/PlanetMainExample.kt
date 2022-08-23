package com.example.jetpackcompleexample.planet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompleexample.PlanetDetails
import com.example.jetpackcompleexample.R
import com.example.jetpackcompleexample.planet.model.Planet
import com.example.jetpackcompleexample.ui.theme.JetpackCompleExampleTheme

class PlanetMainExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCompleExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val planets = listOf<Planet>(
                        Planet("Mercurio", "Mercurio Planeta", R.drawable.mercurio),
                        Planet("Vernus", "Venus Planeta", R.drawable.venus),
                        Planet("Terra", "Terra Planeta", R.drawable.terra),
                        Planet("Marte", "Marte Planeta", R.drawable.marte),
                        Planet("Jupter", "Jupter Planeta", R.drawable.jupiter),
                        Planet("Satuno", "Satuno Planeta", R.drawable.saturno),
                        Planet("Urano", "Urano Planeta", R.drawable.urano),
                        Planet("Netuno", "Netuno Planeta", R.drawable.urano)
                    )

                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "mainScreen") {
                        composable("mainScreen") { ShowScreen(navController, planets) }
                        composable("planetDetailsScreen") {

                            val planet: Planet? =
                                navController.previousBackStackEntry?.savedStateHandle?.get<Planet>(
                                    "planet"
                                )
                            planet?.let {
                                PlanetDetails(navController, it)
                            }
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun planetCard(navController: NavHostController, planet: Planet) {
        Column(
            modifier = Modifier
                .height(120.dp)
                .padding(4.dp),
        ) {

            Card(
                elevation = CardDefaults.elevatedCardElevation(4.dp),
                shape = RoundedCornerShape(15.dp),
                border = BorderStroke(2.dp, color = Color.Blue),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clickable {
                        navController.currentBackStackEntry?.savedStateHandle?.apply {
                            set("planet", planet)
                        }
                        navController.navigate("planetDetailsScreen")
                    }

            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .fillMaxHeight()
                        .padding(15.dp)
                ) {
                    Image(
                        painter = painterResource(id = planet.image),
                        contentDescription = planet.description,
                        modifier = Modifier
                            .width(70.dp)
                            .height(70.dp)
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
            }
        }
    }

    @Composable
    fun ShowScreen(navController: NavHostController, planets: List<Planet>) {
        LazyColumn() {
            itemsIndexed(planets) { _, item ->
                planetCard(navController, planet = item)
            }
        }
    }
}

