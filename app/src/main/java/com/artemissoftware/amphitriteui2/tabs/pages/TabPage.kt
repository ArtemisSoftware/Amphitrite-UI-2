package com.artemissoftware.amphitriteui2.tabs.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.artemissoftware.amphitriteui2.tabs.models.TabPageInfo

@Composable
fun TabPage(
    info: TabPageInfo,
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = info.title,
            style = MaterialTheme.typography.body1,
        )
    }
}