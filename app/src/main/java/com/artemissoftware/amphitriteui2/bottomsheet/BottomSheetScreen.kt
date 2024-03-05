package com.artemissoftware.amphitriteui2.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.material3.rememberStandardBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheetScreen(
    viewModel: CountryViewModel = hiltViewModel(),
) {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = rememberStandardBottomSheetState(
            initialValue = SheetValue.Hidden,
            skipHiddenState = false,
        ),
    )
    val state = viewModel.state.collectAsState().value

    BottomSheetScaffold(
        sheetTonalElevation = 20.dp,
        sheetDragHandle = { Spacer(modifier = Modifier.width(30.dp).height(5.dp).background(Color.Red)) },
        sheetContent = {
            TaskList(
                tasks = state.tasks,
                likeClick = { task -> viewModel.incrementInList(task.id) },
            )
        },
        scaffoldState = scaffoldState,
        content = {
            Button(
                onClick = {
                    scope.launch {
                        scaffoldState.bottomSheetState.expand()
                    }
                },
                content = {
                    Text(text = "Show modal")
                },
            )
        },
    )
}
