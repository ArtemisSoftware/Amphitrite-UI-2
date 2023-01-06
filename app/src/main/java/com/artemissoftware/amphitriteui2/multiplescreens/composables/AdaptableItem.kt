package com.artemissoftware.amphitriteui2.multiplescreens.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui2.multiplescreens.WindowSize
import com.artemissoftware.amphitriteui2.multiplescreens.WindowType
import com.artemissoftware.amphitriteui2.multiplescreens.models.CustomData

@Composable
fun AdaptableItem(data: CustomData, windowSize: WindowSize) {
    val maxLines by remember(key1 = windowSize) {
        mutableStateOf(if (windowSize.width == WindowType.Compact) 4 else 10)
    }

    when (windowSize.height) {
        WindowType.Expanded -> {
            Column {
                ColumnContent(
                    data = data,
                    windowSize = windowSize,
                    maxLines = maxLines
                )
            }
        }
        else -> {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                RowContent(
                    data = data,
                    windowSize = windowSize,
                    maxLines = maxLines
                )
            }
        }
    }
}