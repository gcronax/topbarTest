package com.example.topbartest

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.EaseOut
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.palette.graphics.Palette

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
                var show by remember { mutableStateOf(true) }
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
                var colorRGBSelected: Color by remember { mutableStateOf(Color(0xFF363333)) }
                var colorTitleSelected: Color by remember { mutableStateOf(Color(0xFF000000)) }


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
                                                navController.navigate("Principal")
                                            },
                                            leadingIcon ={
                                                Icon(imageVector = Icons.Filled.Share,
                                                    contentDescription = "stagg")
                                            },
                                            text = {Text(text = stringResource(R.string.stag123) )}

                                        )
                                        DropdownMenuItem(
                                            onClick = { expanded = false
                                                navController.navigate("Secundario")
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
                                containerColor = colorRGBSelected,
                                titleContentColor = colorTitleSelected,
                            )
                        )
                    },
                    floatingActionButton = {

                            FloatingActionButton(
                                onClick = { show=false
                                    navController.navigate("Principal")
                                }
                            ) {
                                Icon(Icons.AutoMirrored.Filled.ArrowBack, "Floating action button.")
                            }


                    }
                )
                { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController, startDestination = "landing",
                        enterTransition = { EnterTransition.None },
                        exitTransition = { ExitTransition.None }                    ) {
                        composable("Principal") {
                            principal(modifier = Modifier.padding(innerPadding),
                                boxes=boxes,
                                imagenSelected = { imagenSelected = it},
                                navController=navController
                            )
                        }
                        composable("Secundario") {
                            secundario(modifier = Modifier.padding(innerPadding),
                                boxes=boxes,
                                imagenSelected = { imagenSelected = it},
                                navController=navController

                            )
                        }
                        composable("Terciario",
                            enterTransition = {
                                fadeIn(
                                    animationSpec = tween(
                                        300, easing = LinearEasing
                                    )
                                ) + slideIntoContainer(
                                    animationSpec = tween(300, easing = EaseIn),
                                    towards = AnimatedContentTransitionScope.SlideDirection.Start
                                )


                            },
                            exitTransition = {
                                fadeOut(
                                    animationSpec = tween(
                                        300, easing = LinearEasing
                                    )
                                ) + slideOutOfContainer(
                                    animationSpec = tween(300, easing = EaseOut),
                                    towards = AnimatedContentTransitionScope.SlideDirection.End
                                )


                            }



                            ) {
                            transformaciones(
                                modifier = Modifier.padding(innerPadding),
                                imagen= imagenSelected,
                                colorRGBSelected = {  colorRGBSelected= it},
                                colorTitleSelected = {  colorTitleSelected= it},
                            )
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
     navController: NavHostController
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
                                navController.navigate("Terciario")
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
    navController: NavHostController

) {
    val gridState = rememberLazyStaggeredGridState()

    LazyColumn(
        modifier= modifier.fillMaxSize(),
        content = {
            items(boxes.size) { indice ->
                Box(
                    modifier = Modifier.padding(5.dp).clickable(
                        onClick = {
                            navController.navigate("Terciario")
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
fun transformaciones(modifier: Modifier,
                     imagen: imagen,
                     colorRGBSelected: (Color) -> Unit,
                     colorTitleSelected: (Color) -> Unit,
                     ) {

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

        )
        val context = LocalContext.current
        val bitmap = remember {
            BitmapFactory.decodeResource(context.resources, imagen.direccion)
        }
        val palette = remember {
            Palette.from(bitmap).generate()
        }

        val vibrant: Palette.Swatch? = palette?.vibrantSwatch
        val darkvibrant: Palette.Swatch? = palette?.darkVibrantSwatch
        val lightvibrant: Palette.Swatch? = palette?.lightVibrantSwatch
        val muted: Palette.Swatch? = palette?.mutedSwatch
        val darkmuted: Palette.Swatch? = palette?.darkMutedSwatch
        val lightmuted: Palette.Swatch? = palette?.lightMutedSwatch


        Row (Modifier.fillMaxWidth().background(
            color = vibrant?.let { Color(it.rgb) } ?: Color.Unspecified,
            )){
            Text("vibrant",
                color = vibrant?.let { Color(it.titleTextColor) } ?: Color.Unspecified,
            )
        }
        colorRGBSelected(vibrant?.let { Color(it.rgb) } ?: Color.Unspecified)
        colorTitleSelected(vibrant?.let { Color(it.titleTextColor) } ?: Color.Unspecified)
        Row (Modifier.fillMaxWidth().background(
            color = darkvibrant?.let { Color(it.rgb) } ?: Color.Unspecified,
        )){
            Text("darkvibrant",
                color = darkvibrant?.let { Color(it.titleTextColor) } ?: Color.Unspecified,
            )
        }
        Row (Modifier.fillMaxWidth().background(
            color = lightvibrant?.let { Color(it.rgb) } ?: Color.Unspecified,
        )){
            Text("lightvibrant",
                color = lightvibrant?.let { Color(it.titleTextColor) } ?: Color.Unspecified,
            )
        }
        Row (Modifier.fillMaxWidth().background(
            color = muted?.let { Color(it.rgb) } ?: Color.Unspecified,
        )){
            Text("muted",
                color = muted?.let { Color(it.titleTextColor) } ?: Color.Unspecified,
            )
        }
        Row (Modifier.fillMaxWidth().background(
            color = darkmuted?.let { Color(it.rgb) } ?: Color.Unspecified,
        )){
            Text("darkmuted",
                color = darkmuted?.let { Color(it.titleTextColor) } ?: Color.Unspecified,
            )
        }
        Row (Modifier.fillMaxWidth().background(
            color = lightmuted?.let { Color(it.rgb) } ?: Color.Unspecified,
        )){
            Text("lightmuted",
                color = lightmuted?.let { Color(it.titleTextColor) } ?: Color.Unspecified,
            )
        }



    }



}

