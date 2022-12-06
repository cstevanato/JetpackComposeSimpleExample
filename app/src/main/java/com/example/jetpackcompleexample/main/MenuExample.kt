package com.example.jetpackcompleexample.main

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.jetpackcompleexample.ColumnRowTextExample
import com.example.jetpackcompleexample.SimpleListStateExample
import com.example.jetpackcompleexample.SimpleStateExample
import com.example.jetpackcompleexample.SimpleSumStateExample
import com.example.jetpackcompleexample.crud.SimpleCrudExample
import com.example.jetpackcompleexample.planet.PlanetMainExample
import com.example.jetpackcompleexample.retrofit.RetrofitActivity
import com.example.jetpackcompleexample.tab.TabExample
import com.example.jetpackcompleexample.ui.theme.JetpackCompleExampleTheme

class MenuExample : ComponentActivity() {
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
        val mContext = LocalContext.current

        val languages = listOf(
            ActivityLocation("TabExample", TabExample::class.java),
            ActivityLocation("SimpleColumnsRow", ColumnRowTextExample::class.java),
            ActivityLocation("SimpleList", SimpleListStateExample::class.java),
            ActivityLocation("SimpleState", SimpleStateExample::class.java),
            ActivityLocation("SimpleSum", SimpleSumStateExample::class.java),
            ActivityLocation("Planet", PlanetMainExample::class.java),
            ActivityLocation("Crud", SimpleCrudExample::class.java),
            ActivityLocation("Retrofit", RetrofitActivity::class.java),
        )
        Row(modifier = Modifier.fillMaxWidth()) {

            Spacer(modifier = Modifier.height(10.dp))
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                itemsIndexed(languages) { _, item ->
                    Button(
                        onClick = {
                            val intent =
                                Intent(mContext, item.clazz)
                            mContext.startActivity(intent)
                        },
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 8.dp, end = 8.dp)

                    ) {
                        Text(text = item.name)
                    }
                }
            }
        }
    }

}
