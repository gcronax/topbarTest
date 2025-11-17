package com.example.topbartest

import android.R.attr.onClick
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.snapping.SnapPosition
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.topbartest.ui.theme.TopbarTestTheme
import com.example.topbartest.ui.theme.primary
import com.example.topbartest.ui.theme.secondary
import java.nio.file.WatchEvent
import kotlin.text.contains

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TopbarTestTheme {
                var tituloPasado by rememberSaveable { mutableStateOf("IES caminas") }
                var show by remember { mutableStateOf(false) }
                var select by remember { mutableIntStateOf(1) }

                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = { Text(text = tituloPasado)
                                    },
                            actions = {
                                var expanded by remember { mutableStateOf(false) }

                                Column(Modifier.padding(20.dp)) {
                                    IconButton(
                                        onClick = {
                                        expanded = true
                                    }) {
                                        Icon(imageVector = Icons.Filled.MoreVert,
                                            contentDescription = "Buscar",
                                            tint= secondary
                                        )
                                    }

                                    DropdownMenu(
                                        expanded = expanded,
                                        onDismissRequest = { expanded = false },
                                    ) {
                                        DropdownMenuItem(
                                            onClick = { expanded = false
                                                select=1
                                            },
                                            leadingIcon ={
                                                Icon(imageVector = Icons.Filled.Share,
                                                    contentDescription = "stagg")
                                            },
                                            text = {Text(text = stringResource(R.string.stag123) )}

                                        )
                                        DropdownMenuItem(
                                            onClick = { expanded = false
                                                      select=2
                                                      },
                                            leadingIcon ={
                                                Icon(imageVector = Icons.Filled.Lock,
                                                    contentDescription = "lazy")
                                            },
                                            text = {Text(text = "lazy")},

                                            )

                                    }
                                }
                            },
                            colors= TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primary,
                                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
                            )
                        )
                    },
                    floatingActionButton = {

                            FloatingActionButton(
                                onClick = { show=false
                                    navController.navigate("Principal")
                                    tituloPasado= "IES caminas"
                                }
                            ) {
                                Icon(Icons.AutoMirrored.Filled.ArrowBack, "Floating action button.")
                            }


                    }
                )
                { innerPadding ->
                    when(select){
                        1->principal(modifier = Modifier.padding(innerPadding))
                        2->secundario(modifier = Modifier.padding(innerPadding))
                    }

                    NavHost(navController = navController, startDestination = "Principal") {
                        composable("Principal") {

                        }
                        composable("Secundario") {

                        }

                    }
                }
            }
        }
    }
}
data class imgenes(

    val direccion: Int,
    val nombre: String

)
@Composable
fun principal(
     modifier: Modifier,
) {
    val gridState = rememberLazyStaggeredGridState()

    val boxes by remember {
        mutableStateOf(listOf(
            imgenes(
                R.drawable.image,
                "cerdo"
            ),
            imgenes(
                R.drawable.image1,
                "cerdo"
            ),
            imgenes(
                R.drawable.image2,
                "cerdo"
            ),
            imgenes(
                R.drawable.image3,
                "cerdo"
            ),
            imgenes(
                R.drawable.image4,
                "cerdo"
            ),
            imgenes(
                R.drawable.image5,
                "cerdo"
            ),
            imgenes(
                R.drawable.image6,
                "cerdo"
            ),
            imgenes(
                R.drawable.image7,
                "cerdo"
            ),
            imgenes(
                R.drawable.image8,
                "cerdo"
            ),
            imgenes(
                R.drawable.image,
                "cerdo"
            ),
            imgenes(
                R.drawable.image1,
                "cerdo"
            ),
            imgenes(
                R.drawable.image2,
                "cerdo"
            ),
            imgenes(
                R.drawable.image3,
                "cerdo"
            ),
            imgenes(
                R.drawable.image4,
                "cerdo"
            ),
            imgenes(
                R.drawable.image5,
                "cerdo"
            ),
            imgenes(
                R.drawable.image6,
                "cerdo"
            ),
            imgenes(
                R.drawable.image7,
                "cerdo"
            ),
            imgenes(
                R.drawable.image8,
                "cerdo"
            ),

        ))
    }
    LazyVerticalStaggeredGrid(
        modifier= modifier.fillMaxSize(),
        columns = StaggeredGridCells.Fixed(2),
        state = gridState,
        content = {
            items(boxes.size) { indice ->
                    Box(
                        modifier = Modifier.padding(5.dp)
                    ) {

                        Image(
                            painter = painterResource(boxes[indice].direccion),
                            contentDescription = null
                        )
                        Text(
                            text = boxes[indice].nombre,
                            modifier = Modifier.padding(5.dp)
                        )
                    }

            }
        })
}

@Composable
fun secundario(
    modifier: Modifier = Modifier
) {
    val gridState = rememberLazyStaggeredGridState()

    val boxes by remember {
        mutableStateOf(listOf(
            imgenes(
                R.drawable.image,
                "cerdo"
            ),
            imgenes(
                R.drawable.image1,
                "cerdo"
            ),
            imgenes(
                R.drawable.image2,
                "cerdo"
            ),
            imgenes(
                R.drawable.image3,
                "cerdo"
            ),
            imgenes(
                R.drawable.image4,
                "cerdo"
            ),
            imgenes(
                R.drawable.image5,
                "cerdo"
            ),
            imgenes(
                R.drawable.image6,
                "cerdo"
            ),
            imgenes(
                R.drawable.image7,
                "cerdo"
            ),
            imgenes(
                R.drawable.image8,
                "cerdo"
            ),
            imgenes(
                R.drawable.image,
                "cerdo"
            ),
            imgenes(
                R.drawable.image1,
                "cerdo"
            ),
            imgenes(
                R.drawable.image2,
                "cerdo"
            ),
            imgenes(
                R.drawable.image3,
                "cerdo"
            ),
            imgenes(
                R.drawable.image4,
                "cerdo"
            ),
            imgenes(
                R.drawable.image5,
                "cerdo"
            ),
            imgenes(
                R.drawable.image6,
                "cerdo"
            ),
            imgenes(
                R.drawable.image7,
                "cerdo"
            ),
            imgenes(
                R.drawable.image8,
                "cerdo"
            ),

            ))
    }
    LazyColumn(
        modifier= modifier.fillMaxSize(),
        content = {
            items(boxes.size) { indice ->
                Box(
                    modifier = Modifier.padding(5.dp)
                ) {

                    Image(
                        painter = painterResource(boxes[indice].direccion),
                        contentDescription = null,
//                        modifier= Modifier.height(400.dp),
                        contentScale = ContentScale.Crop

                    )
                    Text(
                        text = boxes[indice].nombre,
                        modifier = Modifier.padding(5.dp)
                    )
                }

            }
        })
}


@Composable
fun IconDropDownMenu(modifier: Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Column(Modifier.padding(20.dp)) {
        IconButton(onClick = {
            expanded = true
        }) {
            Icon(imageVector = Icons.Filled.MoreVert,
                contentDescription = "Buscar",
                tint= secondary
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
//            modifier = modifier.align(Alignment.End)
        ) {
            DropdownMenuItem(
                onClick = { expanded = false
                          },
                leadingIcon ={
                    Icon(imageVector = Icons.Filled.Share,
                        contentDescription = "Compartir")
                },
                text = {Text(text = "Compartir")}

            )
            DropdownMenuItem(
                onClick = { expanded = false },
                leadingIcon ={
                    Icon(imageVector = Icons.Filled.Lock,
                        contentDescription = "Compartir")
                },
                text = {Text(text = "Album")},

                )

        }
    }
}
