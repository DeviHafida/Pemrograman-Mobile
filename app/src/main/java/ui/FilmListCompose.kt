package ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.modul3.model.Film

@Composable
fun FilmListCompose(
    filmList: List<Film>,
    onWatchClick: (String) -> Unit,
    onDetailClick: (String) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 8.dp, vertical = 8.dp)
    ) {
        items(filmList) { film ->
            FilmCard(film, onWatchClick, onDetailClick)
        }
    }
}

@Composable
fun FilmCard(
    film: Film,
    onWatchClick: (String) -> Unit,
    onDetailClick: (String) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = film.imageResId),
                contentDescription = film.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = film.title, style = MaterialTheme.typography.titleMedium)
            Text(text = "${film.genre} • ${film.year}", color = Color.Gray)

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(onClick = { onWatchClick(film.trailerUrl) }) {
                    Text("Watch Trailer")
                }
                Button(onClick = { onDetailClick(film.title) }) {
                    Text("Details")
                }
            }
        }
    }
}