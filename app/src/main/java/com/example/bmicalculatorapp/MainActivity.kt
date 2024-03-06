package com.example.bmicalculatorapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.bmicalculatorapp.ui.theme.BmiCalculatorAppTheme
import androidx.compose.material3.MaterialTheme as MaterialTheme1
import androidx.compose.runtime.getValue
import androidx.compose.runtime.MutableState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BmiCalculatorAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme1.colorScheme.background
                ) {
                    BmiCalculatorContent()
                }
            }
        }
    }
}

@Composable
fun BmiCalculatorContent() {
    val viewModel: BMIViewModel = viewModel()

    BmiCalculatorApp(viewModel)
}

@Composable
fun BmiCalculatorApp(viewModel: BMIViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        OutlinedTextField(
            value = viewModel.height.value,
            onValueChange = { newValue ->
                viewModel.height.value = newValue
                viewModel.calculateBMI() // Call calculateBMI() when height changes
            },
            label = { Text("Height (m)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = viewModel.weight.value,
            onValueChange = { newValue ->
                viewModel.weight.value = newValue
                viewModel.calculateBMI() // Call calculateBMI() when weight changes
            },
            label = { Text("Weight (kg)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text(
            text = "BMI: ${viewModel.bmi.value}",
            style = TextStyle(fontSize = 16.sp) // Custom style with font size 16sp
        )
    }
}
