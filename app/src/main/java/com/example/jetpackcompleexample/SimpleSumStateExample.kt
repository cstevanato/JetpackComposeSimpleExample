@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jetpackcompleexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.jetpackcompleexample.ui.theme.JetpackCompleExampleTheme

class SimpleSumStateExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCompleExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShowColumnNewStateScreen()
                }
            }
        }
    }
}


@Composable
fun ShowColumnNewStateScreen() {

    var valueA: String by remember {
        mutableStateOf("0.0")
    }

    var valueB: String by remember {
        mutableStateOf("0.0")
    }

    var valueC: String by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(all = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Digite o primeiro valor") },
            value = valueA,
            onValueChange = {
                valueA = it
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Digite o segundo valor") },
            value = valueB,
            onValueChange = {
                valueB = it
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = {
                val vA = valueA.toDouble()
                val vB = valueB.toDouble()
                valueC = (vA + vB).toString()
            }) {
            Text(text = "Somar elementos")
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Resultado: $valueC")
    }
}