package com.example.cacatesouro

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.cacatesouro.ui.theme.CacaTesouroTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = "/home",
                clickB1 = { navController.navigate("/tela2") },
                clickB2 = { navController.navigate("/tela3") }
            ) {
                //builder que fornece telas para o NavHost
                composable("/home") {
                    Tela("home")
                }
                composable("/tela2") {
                    Tela("tela2")
                }
                composable("/tela3") {
                    Tela("tela3")
                }
                composable("/tela4") {
                    Tela("tela4")
                }
            }
        }
    }
}

@Composable
fun Tela(
    nomeTela: String,
    clickB1: () -> Unit = {},
    clickB2: () -> Unit = {},
    ) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = nomeTela)
        Button(onClick = {clickB1}) { Text("B1") }
        Button(onClick = {clickB2}) { Text("B2") }
    }
}

@Preview
@Composable
fun TelaPreview(){
    Tela("Tela Principal"),
    clickB1 = {},
    clickB2 = {},
}
