package com.example.doubledice

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.doubledice.ui.theme.DoubleDiceTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    var result1 by remember { mutableIntStateOf(1) }
    var result2 by remember { mutableIntStateOf(1) }

    val diceImage1 = painterResource(id = getDiceImage(result1))
    val diceImage2 = painterResource(id = getDiceImage(result2))

    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = diceImage1,
                    contentDescription = "Dice 1: $result1",
                    modifier = Modifier.size(120.dp)
                )
                Image(
                    painter = diceImage2,
                    contentDescription = "Dice 2: $result2",
                    modifier = Modifier.size(120.dp)
                )
            }

            Spacer(modifier = Modifier.size(32.dp))

            Button(onClick = {
                result1 = (1..6).random()
                result2 = (1..6).random()

                if (result1 == result2) {
                    Toast.makeText(context, "Selamat, anda dapat dadu double!", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, "Anda belum beruntung!", Toast.LENGTH_SHORT).show()
                }
            }) {
                Text(text = "Roll Dice")
            }
        }
    }
}

fun getDiceImage(result: Int): Int {
    return when (result) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    DoubleDiceTheme {
        HomeScreen()
    }
}
