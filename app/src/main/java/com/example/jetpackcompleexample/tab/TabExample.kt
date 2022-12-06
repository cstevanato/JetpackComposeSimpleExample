package com.example.jetpackcompleexample.tab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompleexample.ui.theme.JetpackCompleExampleTheme

class TabExample : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackCompleExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }

                TabLayout(listOf("Texto 1", "Texto 2", "Texto 4"))


            }
        }
    }
}

@Composable
fun TabLayout(
    tabItems: List<String>,
    content: @Composable () -> Unit = {}
) {
    var tabIndex by remember { mutableStateOf(0) }
    Column {
        ScrollableTabRow(
            selectedTabIndex = tabIndex,
            edgePadding = 4.dp,
            //backgroundColor = MaterialTheme.colors.background,
            contentColor = Color.Green,
            indicator = { tabPositions ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[tabIndex])
                        .height(4.dp)
                        .clip(RoundedCornerShape(8.dp)) // clip modifier not working
                        .padding(horizontal = 28.dp)
                        .background(color = Color.Blue)
                )
            },
            divider = {
                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .height(2.dp)
                    .background(Color.Green))
            },
        ) {
            tabItems.forEachIndexed { index, item ->
                Tab(
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                    selectedContentColor = Color.Cyan,
                    unselectedContentColor = Color.Gray,
                    text = {
                        Text(text = item, fontSize = 18.sp)
                    }
                )
            }
            Divider(
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            )
        }

        content()
    }
}