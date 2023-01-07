package com.artemissoftware.amphitriteui2

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.artemissoftware.amphitriteui2.categoriestable.TableCategoriesScreen
import com.artemissoftware.amphitriteui2.categoriestable.models.Categories
import com.artemissoftware.amphitriteui2.creditcard.CreditCardScreen
import com.artemissoftware.amphitriteui2.islands.Island
import com.artemissoftware.amphitriteui2.multiplescreens.MultipleSreensScreen
import com.artemissoftware.amphitriteui2.multiplescreens.WindowSize

@Composable
fun SelectorScreen(navController: NavHostController) {

    LazyColumn(
        modifier = Modifier.fillMaxHeight(),
        //verticalArrangement = Arrangement.spacedBy(24.dp)
    ) {
        item {

            Demo(
                title = "Islands",
                navController,
                Destinations.Islands
            )
        }
        item {

            Demo(
                title = "Credit cards\n(rotation animation)",
                navController,
                Destinations.CreditCards
            )
        }
        item {

            Demo(
                title = "Multiple screens",
                navController,
                Destinations.MultipleScreens
            )
        }
        item {

            Demo(
                title = "Categories Table",
                navController,
                Destinations.CategoriesTable
            )
        }
    }



}



sealed class Destinations(val route: String){
    object Home: Destinations("home_screen")
    object Islands: Destinations("islands_screen")
    object CreditCards: Destinations("credit_cards_screen")
    object MultipleScreens: Destinations("multiple_screens_screen")
    object CategoriesTable: Destinations("categories_table_screen")
}

@Composable
fun SetupNavGraph(navController: NavHostController, window: WindowSize) {
    NavHost(
        navController = navController,
        startDestination = Destinations.Home.route
    ) {
        composable(route = Destinations.Home.route){
            SelectorScreen(navController)
        }
        composable(route = Destinations.Islands.route){
            SingleContent{
                Island()
            }
        }
        composable(route = Destinations.CreditCards.route){
            CreditCardScreen()
        }
        composable(route = Destinations.MultipleScreens.route){
            MultipleSreensScreen(window)
        }
        composable(route = Destinations.CategoriesTable.route){
            TableCategoriesScreen(Categories.mock(30))
        }
    }
}


@Composable
fun Demo(title: String, navController: NavHostController, destination: Destinations) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(14.dp)
            .clickable {
                navController.navigate(destination.route)
            },
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            modifier = Modifier.fillMaxWidth()

        )

        Divider(startIndent = 16.dp, thickness = 1.dp, color = Color.LightGray, modifier = Modifier.padding(top = 12.dp))
    }

}