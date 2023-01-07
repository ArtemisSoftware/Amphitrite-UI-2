package com.artemissoftware.amphitriteui2.categoriestable.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui2.categoriestable.models.Category

@Composable
fun CategoryBox(
    item: Category,
    modifier: Modifier = Modifier,
) {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = item.label,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
@Preview(showBackground = true)
private fun CategoryBoxPreview() {
    CategoryBox(Category.mock)
}