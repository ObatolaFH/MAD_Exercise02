package com.example.movieappmad24.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieappmad24.models.Movie
import com.example.movieappmad24.models.getMovies

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(movieId: String?, navController: NavController) {
    val movie: Movie? = getMovies().find { it.id == movieId }
    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    if (movie != null) {
                        Text(movie.title)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {navController.popBackStack()}) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        },
    ){ innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
        ) {
            if (movie != null) {
                MovieRow(movie = movie)
            }

            LazyRow(){
                if (movie != null) {
                    items(movie.images) {image ->
                        Card(
                            modifier = Modifier
                                .padding(10.dp)
                                .width(350.dp)
                        ){
                            MovieImage(imageUrl = image)
                        }
                    }
                }

            }
        }

    }
}