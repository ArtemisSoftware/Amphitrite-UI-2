package com.artemissoftware.amphitriteui2.multiplescreens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.artemissoftware.amphitriteui2.multiplescreens.composables.AdaptableItem

@Composable
fun MultipleSreensScreen(
    windowSize: WindowSize,
    homeViewModel: MultipleSreensViewModel = viewModel()
) {
        val items = homeViewModel.items

        LazyColumn(
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items = items, key = { it.id }) {
                AdaptableItem(data = it, windowSize = windowSize)
            }
        }
    }



