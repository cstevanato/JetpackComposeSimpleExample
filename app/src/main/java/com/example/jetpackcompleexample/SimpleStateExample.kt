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


class SimpleStateExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCompleExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShowColumnStateScreen()
                }
            }
        }
    }
}


@Composable
fun ShowColumnStateScreen() {

    var wordText by remember {
        mutableStateOf("Ola mundo")
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))
        OutlinedTextField(
            value = wordText,
            onValueChange = {
                wordText = it
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = wordText)
    }
}