package com.artemissoftware.amphitriteui2.categoriestable

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui2.categoriestable.composables.CategoryBox
import com.artemissoftware.amphitriteui2.categoriestable.composables.MonthBox
import com.artemissoftware.amphitriteui2.categoriestable.composables.TableRow
import com.artemissoftware.amphitriteui2.categoriestable.models.Categories


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TableCategoriesScreen(
    categories : Categories
) {
    val leftColumnWidth = 120.dp
    val rowWidth = 64.dp
    val rowHeight = 40.dp

    val verticalScroll = rememberScrollState()
    val horizontalScroll = rememberScrollState()

    Scaffold { innerPadding ->
        BoxWithConstraints(
            modifier = Modifier
                .padding(innerPadding)
                .consumedWindowInsets(innerPadding)
        ) {


            Column {
                // Months
                Row {
                    Box(modifier = Modifier.width(leftColumnWidth))
                    Row(
                        modifier = Modifier.horizontalScroll(horizontalScroll)
                    ) {
                        categories.months.forEach { month ->
                            MonthBox(
                                month = month,
                                modifier = Modifier.width(64.dp)
                            )
                        }
                    }
                }

                Row {
                    // Category Labels
                    Column(
                        modifier = Modifier
                            .width(leftColumnWidth)
                            .verticalScroll(verticalScroll)
                    ) {
                        categories.categories.forEach { category ->
                            CategoryBox(
                                item = category,
                                modifier = Modifier.height(rowHeight)
                            )
                        }
                    }

                    // Expenses/Category/Month
                    Column(
                        modifier = Modifier
                            .verticalScroll(verticalScroll)
                            .horizontalScroll(horizontalScroll)
                    ) {
                        categories.categoriesByMonth.forEach {
                            TableRow(
                                items = it.items,
                                itemModifier = Modifier
                                    .width(rowWidth)
                                    .height(rowHeight)
                            )
                        }
                    }
                }
            }
        }
    }


}

@Composable
@Preview(showBackground = true)
private fun TableCategoriesScreenPreview() {
    TableCategoriesScreen(
        categories = Categories.mock(30)
    )
}
