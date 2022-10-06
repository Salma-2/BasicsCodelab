package com.salma.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue


import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun StatelessCounter(
    count: Int,
    onIncrement: () -> Unit,
    onReset: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            // This text is present if the button has been clicked at least once; absent otherwise
            Text(
                text =
                if (count >= 10) "You've reached your goal for the day"
                else "You've had $count glasses."
            )
        }
        Row(modifier = modifier.padding(top = 8.dp)) {
            Button(
                onClick = { onIncrement() },
                enabled = count < 10
            ) {
                Text(
                    text = "Add one"
                )
            }

            Button(
                onClick = { onReset() },
                enabled = count > 0,
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text(text = "Clear water count")
            }
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable {
        mutableStateOf(0)
    }
    StatelessCounter(
        count = count,
        onIncrement = { count++ },
        onReset = { count = 0 },
        modifier = modifier)
}

@Composable
fun WellnessTaskItem(
    taskName: String,
    onClose: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically)
    {
        Text(
            text = taskName,
            modifier = modifier.weight(1f)
        )
        IconButton(
            onClick = onClose
        ) {
            Icon(imageVector = Icons.Filled.Close,
                contentDescription = "Close")
        }
    }
}

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    StatefulCounter(modifier)
}
