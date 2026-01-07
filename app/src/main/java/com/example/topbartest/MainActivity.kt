package com.example.topbartest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableDoubleStateOf
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.example.topbartest.ui.theme.TopbarTestTheme
import com.example.topbartest.ui.theme.secondary


class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TopbarTestTheme {
                var tituloPasado by rememberSaveable { mutableStateOf("Places in the world") }
                var show by remember { mutableStateOf(false) }
                var select by remember { mutableIntStateOf(1) }
                val navController = rememberNavController()
                val boxes by remember {
                    mutableStateOf(listOf(
                        imagen(
                            R.drawable.image,
                            "image"
                        ),
                        imagen(
                            R.drawable.image1,
                            "image1"
                        ),
                        imagen(
                            R.drawable.image2,
                            "image2"
                        ),
                        imagen(
                            R.drawable.image3,
                            "image3"
                        ),
                        imagen(
                            R.drawable.image4,
                            "image4"
                        ),
                        imagen(
                            R.drawable.image5,
                            "image5"
                        ),
                        imagen(
                            R.drawable.image6,
                            "image6"
                        ),
                        imagen(
                            R.drawable.image7,
                            "image7"
                        ),
                        imagen(
                            R.drawable.image8,
                            "image8"
                        ),
                        imagen(
                            R.drawable.image,
                            "image"
                        ),
                        imagen(
                            R.drawable.image1,
                            "image1"
                        ),
                        imagen(
                            R.drawable.image2,
                            "image2"
                        ),
                        imagen(
                            R.drawable.image3,
                            "image3"
                        ),
                        imagen(
                            R.drawable.image4,
                            "image4"
                        ),
                        imagen(
                            R.drawable.image5,
                            "image5"
                        ),
                        imagen(
                            R.drawable.image6,
                            "image6"
                        ),
                        imagen(
                            R.drawable.image7,
                            "image7"
                        ),
                        imagen(
                            R.drawable.image8,
                            "image8"
                        ),

                        ))
                }
                var imagenSelected by remember { mutableStateOf(boxes[0]) }


                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = { Text(text = tituloPasado,
                                color = Color(0xFFFFFFFF)
                                )
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
                        1->principal(modifier = Modifier.padding(innerPadding),
                            boxes=boxes,
                            imagenSelected = { imagenSelected = it},
                            select={select=it}
                            )
                        2->secundario(modifier = Modifier.padding(innerPadding),
                            boxes=boxes,
                            imagenSelected = { imagenSelected = it},
                            select={select=it}


                        )
                        3->transformaciones(
                            modifier = Modifier.padding(innerPadding),
                            imagen= imagenSelected
                        )
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


data class imagen(

    val direccion: Int,
    val nombre: String

)
@Composable
fun principal(
     modifier: Modifier,
     boxes: List<imagen>,
     imagenSelected: (imagen) -> Unit,
     select: (Int)-> Unit
) {
    val gridState = rememberLazyStaggeredGridState()

    LazyVerticalStaggeredGrid(
        modifier= modifier.fillMaxSize(),
        columns = StaggeredGridCells.Fixed(2),
        state = gridState,
        content = {
            items(boxes.size) { indice ->
                    Box(
                        modifier = Modifier.padding(5.dp).clickable(
                            onClick = {
                                select(3)
                                imagenSelected(boxes[indice])
                            }
                        )
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
    modifier: Modifier = Modifier,
    boxes: List<imagen>,
    imagenSelected: (imagen) -> Unit,
    select: (Int)-> Unit

) {
    val gridState = rememberLazyStaggeredGridState()

    LazyColumn(
        modifier= modifier.fillMaxSize(),
        content = {
            items(boxes.size) { indice ->
                Box(
                    modifier = Modifier.padding(5.dp).clickable(
                        onClick = {
                            select(3)
                            imagenSelected(boxes[indice])
                        }
                    )
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
fun transformaciones(modifier: Modifier, imagen: imagen) {
    var selectR by remember { mutableFloatStateOf(1.0f) }
    var selectS by remember { mutableFloatStateOf(1.0f) }
    var selectA by remember { mutableFloatStateOf(1.0f) }
    var selectB by remember { mutableFloatStateOf(0.0f) }



    Column(modifier.fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally
        ) {


        Text(
            text = imagen.nombre,
            modifier = Modifier.padding(20.dp)
        )

        Image(
            painter = painterResource(imagen.direccion),
            contentDescription = null,
                    modifier = Modifier.blur(
                        radiusX = selectB.dp,
                        radiusY = selectB.dp,
                        edgeTreatment = BlurredEdgeTreatment.Unbounded)
                .graphicsLayer {
                    this.scaleX= selectS
                    this.rotationY = selectR
                    this.alpha = selectA

                }
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Text("rotación")
            Slider(
                value = selectR,
                onValueChange = { selectR = it },
                valueRange = 0f..500f
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Text("escalado")
            Slider(
                value = selectS,
                onValueChange = { selectS = it },
                valueRange = 0f..50f
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Text("alpha")
            Slider(
                value = selectA,
                onValueChange = { selectA = it },
                valueRange = 0f..1f
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Text("desenfoque")
            Slider(
                value = selectB,
                onValueChange = { selectB = it },
                valueRange = 0f..100f
            )
        }

    }



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
