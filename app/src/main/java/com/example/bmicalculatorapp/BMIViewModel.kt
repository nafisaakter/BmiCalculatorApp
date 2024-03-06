package com.example.bmicalculatorapp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class BMIViewModel : ViewModel() {
    val height: MutableState<String> = mutableStateOf("")
    val weight: MutableState<String> = mutableStateOf("")
    val bmi: MutableState<Float> = mutableStateOf(0.0f)

    fun calculateBMI() {
        val heightValue = height.value.toFloatOrNull() ?: 0.0f
        val weightValue = weight.value.toFloatOrNull() ?: 0.0f

        bmi.value = if (heightValue > 0 && weightValue > 0) {
            weightValue / (heightValue * heightValue)
        } else {
            0.0f
        }
    }
}
