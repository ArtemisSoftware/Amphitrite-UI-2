package com.artemissoftware.amphitriteui2.categoriestable.composables

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun MonthBox(
    month: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = month,
        maxLines = 1,
        fontSize = 8.sp,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

@Composable
@Preview(showBackground = true)
private fun MonthBoxPreview() {
    MonthBox(month = "January")
}