package com.artemissoftware.amphitriteui2.multipletheme

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.artemissoftware.amphitriteui2.Graphs
import com.artemissoftware.amphitriteui2.ui.theme.ThemeType

fun NavGraphBuilder.multipleThemeNavGraph(navController: NavHostController) {
    navigation(
        route = Graphs.MultipleThemeNavGraph.name,
        startDestination = MultipleThemeScreens.Blue.route,
    ) {
        composable(route = MultipleThemeScreens.Blue.route) {
            BlueScreen(
                onClick = {
                    // navController.popBackStack()
                    navController.navigate(MultipleThemeScreens.Red.route)
                },
            )
        }
        composable(route = MultipleThemeScreens.Red.route) {
            RedScreen(
                onClick = {
                    // navController.popBackStack()
                    navController.navigate(MultipleThemeScreens.Green.route)
                },
            )
        }
        composable(route = MultipleThemeScreens.Green.route) {
            GreenScreen(
                onClick = {
                    navController.popBackStack()
                },
            )
        }
    }
}

sealed class MultipleThemeScreens(val route: String, val themeType: ThemeType) {
    data object Red : MultipleThemeScreens(route = "Red", themeType = ThemeType.Red)
    data object Blue : MultipleThemeScreens(route = "Blue", themeType = ThemeType.Blue)
    data object Green : MultipleThemeScreens(route = "Green", themeType = ThemeType.Green)

    companion object{
        fun getTheme(route: String? = null): ThemeType {
            return when {
                Red.route == route -> Red.themeType
                Blue.route == route -> Blue.themeType
                Green.route == route -> Green.themeType
                else -> ThemeType.Default
            }
        }
    }
}
