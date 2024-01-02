package com.artemissoftware.amphitriteui2

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.artemissoftware.amphitriteui2.animations.animatedcontent.AnimatedContentScreen
import com.artemissoftware.amphitriteui2.animations.glow.Glow
import com.artemissoftware.amphitriteui2.animations.imagetransition.ImageTransitionScreen
import com.artemissoftware.amphitriteui2.animations.sharedelementtransition.MountainListScreen
import com.artemissoftware.amphitriteui2.animations.sharedelementtransition.MountainScreen
import com.artemissoftware.amphitriteui2.animations.waterbottle.WaterBottleScreen
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
import com.artemissoftware.amphitriteui2.stopwatch.StopWatchScreen
import com.artemissoftware.amphitriteui2.stopwatch.StopWatchViewModel
import com.artemissoftware.amphitriteui2.tabs.TabScreen
import com.artemissoftware.amphitriteui2.verticalslider.VerticalSlider

@Composable
fun SelectorScreen(navController: NavHostController) {

    LazyColumn {
        items(demos) { demo ->
            Demo(
                title = demo.title,
                navController,
                demo.destination,
            )
        }
    }

//    LazyColumn(
//        modifier = Modifier.fillMaxHeight(),
//        // verticalArrangement = Arrangement.spacedBy(24.dp)
//    ) {
//        item {
//            Demo(
//                title = "Islands",
//                navController,
//                Destinations.Islands,
//            )
//        }
//        item {
//            Demo(
//                title = "Credit cards\n(rotation animation)",
//                navController,
//                Destinations.CreditCards,
//            )
//        }
//        item {
//            Demo(
//                title = "Multiple screens",
//                navController,
//                Destinations.MultipleScreens,
//            )
//        }
//        item {
//            Demo(
//                title = "Categories Table",
//                navController,
//                Destinations.CategoriesTable,
//            )
//        }
//        item {
//            Demo(
//                title = "Circular slider",
//                navController,
//                Destinations.CircularSlider,
//            )
//        }
//        item {
//            Demo(
//                title = "Tabs",
//                navController,
//                Destinations.Tabs,
//            )
//        }
//        item {
//            Demo(
//                title = "Epoch",
//                navController,
//                Destinations.Epoch,
//            )
//        }
//        item {
//            Demo(
//                title = "DraggableBox",
//                navController,
//                Destinations.DraggableBox,
//            )
//        }
//        item {
//            Demo(
//                title = "Vertical Slider",
//                navController,
//                Destinations.VerticalSlider,
//            )
//        }
//        item {
//            Demo(
//                title = "Drag and Drop",
//                navController,
//                Destinations.DragDrop,
//            )
//        }
//        item {
//            Demo(
//                title = "Glow",
//                navController,
//                Destinations.Glow,
//            )
//        }
//        item {
//            Demo(
//                title = "Image Transition with Animation",
//                navController,
//                Destinations.ImageTransition,
//            )
//        }
//        item {
//            Demo(
//                title = "Shared Element Transition Animation",
//                navController,
//                Destinations.SharedElementTransitionAnimation,
//            )
//        }
//        item {
//            Demo(
//                title = "Shared Element Transition with list Animation",
//                navController,
//                Destinations.SharedElementTransitionWithListAnimation,
//            )
//        }
//        item {
//            Demo(
//                title = "Animated content",
//                navController,
//                Destinations.AnimatedContent,
//            )
//        }
//
//        item {
//            Demo(
//                title = "Water Bottle",
//                navController,
//                Destinations.WaterBottle,
//            )
//        }
//    }
}

sealed class Destinations(val route: String) {
    data object Home : Destinations("home_screen")
    data object Islands : Destinations("islands_screen")
    data object CreditCards : Destinations("credit_cards_screen")
    data object MultipleScreens : Destinations("multiple_screens_screen")
    data object CategoriesTable : Destinations("categories_table_screen")
    data object CircularSlider : Destinations("circular_slider_screen")
    data object Tabs : Destinations("tabs_screen")
    data object Epoch : Destinations("epoch_screen")
    data object DraggableBox : Destinations("draggable_box_screen")
    data object VerticalSlider : Destinations("vertical_slider_screen")
    data object DragDrop : Destinations("drag_drop_screen")
    data object Glow : Destinations("glow_screen")
    data object ImageTransition : Destinations("image_transition_screen")
    data object SharedElementTransitionAnimation : Destinations("shared_element_transition_animation")
    data object SharedElementTransitionWithListAnimation : Destinations("shared_element_transition_list_animation")
    data object AnimatedContent : Destinations("animated_content")

    data object WaterBottle : Destinations("water_bottle")
    data object StopWatch : Destinations("stop_watch")
}

private val demos = listOf(
    DemoData(title = "Islands", destination = Destinations.Islands),
    DemoData(title = "Stop watch", destination = Destinations.StopWatch)
)

@Composable
fun SetupNavGraph(
    navController: NavHostController,
    window: WindowSize,
    dragDropViewModel: DragDropViewModel,
    stopWatchViewModel: StopWatchViewModel
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
                var value by remember { mutableFloatStateOf(0f) }
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
        composable(route = Destinations.ImageTransition.route) {
            ImageTransitionScreen()
        }
        composable(route = Destinations.SharedElementTransitionAnimation.route) {
            MountainScreen()
        }
        composable(route = Destinations.SharedElementTransitionWithListAnimation.route) {
            MountainListScreen()
        }
        composable(route = Destinations.AnimatedContent.route) {
            AnimatedContentScreen()
        }
        composable(route = Destinations.WaterBottle.route) {
            WaterBottleScreen()
        }
        composable(route = Destinations.StopWatch.route) {
            StopWatchScreen(viewModel = stopWatchViewModel)
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

private data class DemoData(
    val title: String,
    val destination: Destinations,
)
