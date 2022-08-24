@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jetpackcompleexample.crud

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcompleexample.PlanetDetails
import com.example.jetpackcompleexample.crud.data.entities.City
import com.example.jetpackcompleexample.crud.list.ListComposable
import com.example.jetpackcompleexample.crud.register.RegisterActivity
import com.example.jetpackcompleexample.crud.update.detailsComposable
import com.example.jetpackcompleexample.planet.model.Planet
import com.example.jetpackcompleexample.ui.theme.JetpackCompleExampleTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SimpleCrudExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCompleExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "showScreen"
                    ) {
                        composable(route = "showScreen") {
                            showScreen(navController)
                        }
                        composable(route = "registerScreen") {
                            RegisterActivity(navController = navController)
                        }
                        composable(route = "detailsScreen") {
                            val city: City? =
                                navController.previousBackStackEntry?.savedStateHandle?.get<City>(
                                    "city"
                                )
                            city?.let {
                                detailsComposable(navController = navController, city = it)
                            }
                        }
                    }
                }
            }
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun showScreen(navController: NavController) {
        Scaffold(
            content = { innerPadding ->
                ListComposable(
                    contentPadding = innerPadding,
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    navController = navController
                )
            },
            floatingActionButton =
            {
                FloatingActionButton(onClick = {
                    navController.navigate("registerScreen")
                }) {
                    Icon(Icons.Filled.Add, contentDescription = "")
                }
            },
            topBar = {
                SmallTopAppBar(
                    colors = TopAppBarDefaults
                        .smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
                    title = {
                        Text(
                            "Crud Examples",
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.ArrowBack, "backIcon")
                        }
                    },
                    actions = {
                        IconButton(onClick = { /* doSomething() */ }) {
                            Icon(
                                imageVector = Icons.Filled.Favorite,
                                contentDescription = "Localized description"
                            )
                        }
                    }
                )
            }
        )
    }
}

