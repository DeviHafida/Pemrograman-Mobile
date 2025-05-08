package com.example.tipcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Percent
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tipcalculation.ui.theme.TipCalculationTheme
import kotlin.math.ceil
import androidx.compose.material.icons.filled.AttachMoney as AttachMoney1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipCalculationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TipCalculatorApp()
                }
            }
        }
    }
}

@Composable
fun TipCalculatorApp() {
    var cost by remember { mutableStateOf("") }
    var tipPercent by remember { mutableStateOf(15) }
    var roundUp by remember { mutableStateOf(false) }

    // Ensure cost is a valid number
    val tip = calculateTip(cost.toDoubleOrNull() ?: 0.0, tipPercent, roundUp)

    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Text(
            text = "Calculate Tip",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = cost,
            onValueChange = { cost = it },
            label = { Text("Bill Amount") },
            leadingIcon = { Icon(Icons.Filled.AttachMoney1, contentDescription = null) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        TipPercentageDropdown(selected = tipPercent, onSelected = { tipPercent = it })

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Round up tip?")
            Switch(checked = roundUp, onCheckedChange = { roundUp = it })
        }

        Text(
            text = "Tip Amount: $${String.format("%.2f", tip)}",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF111111)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TipPercentageDropdown(selected: Int, onSelected: (Int) -> Unit) {
    val options = listOf(15, 18, 20)
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        OutlinedTextField(
            value = "$selected%",
            onValueChange = {},
            readOnly = true,
            label = { Text("Tip Percentage") },
            leadingIcon = { Icon(Icons.Filled.Percent, contentDescription = null) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            modifier = Modifier
                .menuAnchor()
                .fillMaxWidth()
        )
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { percent ->
                DropdownMenuItem(
                    text = { Text("$percent%") },
                    onClick = {
                        onSelected(percent)
                        expanded = false
                    }
                )
            }
        }
    }
}

fun calculateTip(amount: Double, tipPercent: Int, roundUp: Boolean): Double {
    var tip = amount * tipPercent / 100
    if (roundUp) tip = ceil(tip)
    return tip
}