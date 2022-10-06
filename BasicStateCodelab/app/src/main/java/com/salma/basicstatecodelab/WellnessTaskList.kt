package com.salma.basicstatecodelab.data

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.salma.basicstatecodelab.WellnessTask
import com.salma.basicstatecodelab.WellnessTaskItem


@Composable
fun WellnessTaskList(
    modifier: Modifier = Modifier,
    tasks: List<WellnessTask>,
    onCloseTask: (WellnessTask) -> Unit,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
) {
    LazyColumn(
        modifier = modifier.padding(16.dp)
    ) {
        items(tasks) { task ->
            WellnessTaskItem(taskName = task.label,
                checked = task.checked,
                onClose = { onCloseTask(task) },
                onCheckedChange = { checked -> onCheckedTask(task, checked) }
            )
        }
    }
}