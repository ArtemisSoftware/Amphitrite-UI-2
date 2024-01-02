package com.artemissoftware.amphitriteui2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.artemissoftware.amphitriteui2.dragdrop.DragDropViewModel
import com.artemissoftware.amphitriteui2.multiplescreens.rememberWindowSize
import com.artemissoftware.amphitriteui2.stopwatch.StopWatchViewModel
import com.artemissoftware.amphitriteui2.ui.theme.AmphitriteUI2Theme

class MainActivity : ComponentActivity() {

    private val dragDropViewModel = DragDropViewModel()
    private val stopWatchViewModel = StopWatchViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmphitriteUI2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    val window = rememberWindowSize()
                    SetupNavGraph(
                        navController = rememberNavController(),
                        window = window,
                        dragDropViewModel = dragDropViewModel,
                        stopWatchViewModel = stopWatchViewModel,
                    )
                }
            }
        }
    }
}
