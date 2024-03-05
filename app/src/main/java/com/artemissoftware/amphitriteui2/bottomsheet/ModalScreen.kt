package com.artemissoftware.amphitriteui2.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun ModalScreen(
    viewModel: CountryViewModel = hiltViewModel(),
) {
    var showSheet by remember { mutableStateOf(false) }
    var showSheet2 by remember { mutableStateOf(false) }
    val state = viewModel.state.collectAsState().value

    if (showSheet) {
        BottomSheet(
            tasks = state.tasks,
            onDismiss = {
                showSheet = false
            },
            likeClick = {
                viewModel.incrementInList(it.id)
            },
        )
    }
    if (showSheet2) {
        BottomSheet2(
            onDismiss = {
                showSheet2 = false
            },
        )
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {
                showSheet = true
            },
            content = {
                Text(text = "Show modal")
            },
        )

        Button(
            onClick = {
                showSheet2 = true
            },
            content = {
                Text(text = "Show modal 2")
            },
        )

        Spacer(modifier = Modifier.height(16.dp))

        TaskList(
            tasks = state.tasks,
            likeClick = { task -> viewModel.incrementInList(task.id) },
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BottomSheet(
    tasks: List<Task>,
    onDismiss: () -> Unit,
    likeClick: (Task) -> Unit,
) {
    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        TaskList(
            tasks = tasks,
            likeClick = likeClick,
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun BottomSheet2(
    onDismiss: () -> Unit,
) {
    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        Box(modifier = Modifier.size(200.dp).background(color = Color.Green))
    }
}
