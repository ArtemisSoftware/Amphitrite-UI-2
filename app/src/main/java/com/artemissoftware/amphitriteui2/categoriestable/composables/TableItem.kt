package com.artemissoftware.amphitriteui2.categoriestable.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.amphitriteui2.categoriestable.models.CategoryTransaction
import com.artemissoftware.amphitriteui2.categoriestable.util.percentageToColor

@Composable
fun TableItem(
    item: CategoryTransaction,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .background(item.percentage.percentageToColor())
    ) {
        Text(
            text = item.amount,
            maxLines = 1
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun MonthBoxPreview() {
    TableItem(CategoryTransaction.mock)
}