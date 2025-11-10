package com.example.topbartest

import android.R.attr.onClick
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.topbartest.ui.theme.TopbarTestTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TopbarTestTheme {
                var tituloPasado by rememberSaveable { mutableStateOf("IES caminas") }
                var show by remember { mutableStateOf(false) }
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = { Text(text = tituloPasado) },
                            colors= TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                            )
                        )
                    },
                    floatingActionButton = {
                        if (show){
                            FloatingActionButton(
                                onClick = { show=false
                                    navController.navigate("Principal")
                                    tituloPasado= "IES caminas"
                                }
                            ) {
                                Icon(Icons.AutoMirrored.Filled.ArrowBack, "Floating action button.")
                            }
                        }

                    }
                )
                { innerPadding ->
                    NavHost(navController = navController, startDestination = "Principal") {
                        composable("Principal") {principal(navController,
                            Modifier.padding(innerPadding),
                            {tituloPasado = it},{show=it})
                        }
                        composable("Secundario") {secundario(navController,
                            Modifier.padding(innerPadding))  }

                    }
                }
            }
        }
    }
}

@Composable
fun principal(navController: NavHostController, modifier: Modifier = Modifier,
              titulo: (String) -> Unit,show: (Boolean) -> Unit) {
    Column (
        modifier=modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
        ){
        TextButton(onClick = {titulo("Información")
                                show(true)
            navController.navigate("Secundario")
                             }, modifier = Modifier
        ) {
            Text("Información")
        }
        TextButton(onClick = {titulo("Administración")
                                show(true)
            navController.navigate("Secundario")

        }, modifier = Modifier
        ) {
            Text("Administración")
        }
        TextButton(onClick = { titulo("Comercio")
                                show(true)
            navController.navigate("Secundario")

        }, modifier = Modifier
        ) {
            Text("Comercio")
        }

    }
}
@Composable
fun secundario(navController: NavHostController, modifier: Modifier = Modifier) {

}

