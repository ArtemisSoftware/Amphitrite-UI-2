package com.artemissoftware.amphitriteui2

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.artemissoftware.amphitriteui2.animations.glow.Glow
import com.artemissoftware.amphitriteui2.categoriestable.TableCategoriesScreen
import com.artemissoftware.amphitriteui2.categoriestable.models.Categories
import com.artemissoftware.amphitriteui2.circularslider.CircularSlider
import com.artemissoftware.amphitriteui2.creditcard.CreditCardScreen
import com.artemissoftware.amphitriteui2.dragdrop.DragDropScreen
import com.artemissoftware.amphitriteui2.dragdrop.DragDropViewModel
import com.artemissoftware.amphitriteui2.draggable.DraggableBox
import com.artemissoftware.amphitriteui2.epoch.EpochScreen
import com.artemissoftware.amphitriteui2.epoch.EpochViewModel
import com.artemissoftware.amphitriteui2.islands.Island
import com.artemissoftware.amphitriteui2.multiplescreens.MultipleSreensScreen
import com.artemissoftware.amphitriteui2.multiplescreens.WindowSize
import com.artemissoftware.amphitriteui2.tabs.TabScreen
import com.artemissoftware.amphitriteui2.verticalslider.VerticalSlider

@Composable
fun SelectorScreen(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier.fillMaxHeight(),
        // verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        item {
            Demo(
                title = "Islands",
                navController,
                Destinations.Islands,
            )
        }
        item {
            Demo(
                title = "Credit cards\n(rotation animation)",
                navController,
                Destinations.CreditCards,
            )
        }
        item {
            Demo(
                title = "Multiple screens",
                navController,
                Destinations.MultipleScreens,
            )
        }
        item {
            Demo(
                title = "Categories Table",
                navController,
                Destinations.CategoriesTable,
            )
        }
        item {
            Demo(
                title = "Circular slider",
                navController,
                Destinations.CircularSlider,
            )
        }
        item {
            Demo(
                title = "Tabs",
                navController,
                Destinations.Tabs,
            )
        }
        item {
            Demo(
                title = "Epoch",
                navController,
                Destinations.Epoch,
            )
        }
        item {
            Demo(
                title = "DraggableBox",
                navController,
                Destinations.DraggableBox,
            )
        }
        item {
            Demo(
                title = "Vertical Slider",
                navController,
                Destinations.VerticalSlider,
            )
        }
        item {
            Demo(
                title = "Drag and Drop",
                navController,
                Destinations.DragDrop,
            )
        }
        item {
            Demo(
                title = "Glow",
                navController,
                Destinations.Glow,
            )
        }
    }
}

sealed class Destinations(val route: String) {
    object Home : Destinations("home_screen")
    object Islands : Destinations("islands_screen")
    object CreditCards : Destinations("credit_cards_screen")
    object MultipleScreens : Destinations("multiple_screens_screen")
    object CategoriesTable : Destinations("categories_table_screen")
    object CircularSlider : Destinations("circular_slider_screen")
    object Tabs : Destinations("tabs_screen")
    object Epoch : Destinations("epoch_screen")
    object DraggableBox : Destinations("draggable_box_screen")
    object VerticalSlider : Destinations("vertical_slider_screen")

    object DragDrop : Destinations("drag_drop_screen")

    object Glow : Destinations("glow_screen")
}

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    window: WindowSize,
    dragDropViewModel: DragDropViewModel,
) {
    NavHost(
        navController = navController,
        startDestination = Destinations.Home.route,
    ) {
        composable(route = Destinations.Home.route) {
            SelectorScreen(navController)
        }
        composable(route = Destinations.Islands.route) {
            SingleContent {
                Island()
            }
        }
        composable(route = Destinations.CreditCards.route) {
            CreditCardScreen()
        }
        composable(route = Destinations.MultipleScreens.route) {
            MultipleSreensScreen(window)
        }
        composable(route = Destinations.CategoriesTable.route) {
            TableCategoriesScreen(Categories.mock(30))
        }
        composable(route = Destinations.CircularSlider.route) {
            SingleContent {
                CircularSlider(
                    modifier = Modifier.size(300.dp),
                ) {
                    Log.d("progress", it.toString())
                }
            }
        }
        composable(route = Destinations.Tabs.route) {
            TabScreen()
        }
        composable(route = Destinations.Epoch.route) {
            val viewModel: EpochViewModel = viewModel()
            EpochScreen(viewModel)
        }
        composable(route = Destinations.DraggableBox.route) {
            SingleContent {
                DraggableBox("1")
                DraggableBox("2")
            }
        }
        composable(route = Destinations.VerticalSlider.route) {
            SingleContent {
                var value by remember { mutableStateOf(0f) }
                VerticalSlider(
                    value = value,
                    onValueChange = {
                        value = it
                    },
                    modifier = Modifier
                        .width(200.dp)
                        .height(50.dp)
                        .background(Color(0xffdedede)),
                )
            }
        }
        composable(route = Destinations.DragDrop.route) {
            DragDropScreen(dragDropViewModel)
        }
        composable(route = Destinations.Glow.route) {
            SingleContent {
                Glow()
            }
        }
    }
}

@Composable
fun Demo(
    title: String,
    navController: NavHostController,
    destination: Destinations,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 12.dp)
            .clickable {
                navController.navigate(destination.route)
            },
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            modifier = Modifier.fillMaxWidth(),

        )

        Divider(startIndent = 16.dp, thickness = 1.dp, color = Color.LightGray, modifier = Modifier.padding(top = 12.dp))
    }
}
