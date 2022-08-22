@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.jetpackcompleexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.jetpackcompleexample.ui.theme.JetpackCompleExampleTheme

class SimpleListStateExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCompleExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShowScreen()
                }
            }
        }
    }


    @Composable
    fun ShowScreen() {
        val languages = listOf("C#", "java", "kotlin","Dart", "js", "PHP")
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            itemsIndexed(languages) { _, item ->
                Text(text = item)
            }
        }
    }
}

