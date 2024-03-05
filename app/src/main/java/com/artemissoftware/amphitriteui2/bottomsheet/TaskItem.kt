package com.artemissoftware.amphitriteui2.bottomsheet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TaskItem(task: Task, onTaskClick: (Task) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onTaskClick(task) }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            imageVector = if (task.isCompleted) Icons.Default.CheckCircle else Icons.Default.Warning,
            contentDescription = null,
            tint = if (task.isCompleted) Color.Green else Color.Red,
            modifier = Modifier.size(24.dp),
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = task.name,
            style = MaterialTheme.typography.body1.copy(
                color = if (task.isCompleted) Color.Gray else Color.Black,
            ),
        )

        Text(
            modifier = Modifier.padding(end = 40.dp),
            text = task.clicks.toString(),
            style = MaterialTheme.typography.body1.copy(
                color = if (task.isCompleted) Color.Gray else Color.Black,
            ),
        )
    }
}

@Composable
fun TaskList(
    tasks: List<Task>,
    likeClick: (Task) -> Unit,
) {
    LazyColumn {
        items(tasks) { task ->
            TaskItem(task = task, onTaskClick = likeClick)
        }
    }
}