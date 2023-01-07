package com.artemissoftware.amphitriteui2.categoriestable.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.amphitriteui2.categoriestable.models.CategoryTransaction

@Composable
fun TableRow(
    items: List<CategoryTransaction>,
    modifier: Modifier = Modifier,
    itemModifier: Modifier = Modifier,
) {
    Row(modifier = modifier) {
        items.forEach { item ->
            TableItem(
                item = item,
                modifier = itemModifier
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun TableRow() {
    TableRow(items = CategoryTransaction.mockList)
}