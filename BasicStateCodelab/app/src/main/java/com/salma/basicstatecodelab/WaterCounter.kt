package com.salma.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    var counter by rememberSaveable {
        mutableStateOf(0)
    }
    Column {
        Text(
            text = "You've had $counter glasses.",
            modifier = modifier.padding(16.dp)
        )
        Button(
            onClick = { counter++ },
            modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Add one"
            )
        }
    }
}


@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    WaterCounter(modifier)
}
