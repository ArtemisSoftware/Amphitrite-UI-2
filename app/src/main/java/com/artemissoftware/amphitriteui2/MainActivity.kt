package com.artemissoftware.amphitriteui2

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.artemissoftware.amphitriteui2.dragdrop.DragDropViewModel
import com.artemissoftware.amphitriteui2.multiplescreens.rememberWindowSize
import com.artemissoftware.amphitriteui2.stopwatch.StopWatchViewModel
import com.artemissoftware.amphitriteui2.ui.theme.AmphitriteUI2Theme

class MainActivity : ComponentActivity() {

    private val dragDropViewModel = DragDropViewModel()
    private val stopWatchViewModel = StopWatchViewModel()
    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !mainViewModel.isReady.value
            }
            setOnExitAnimationListener { screen ->
                val zoomX = ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_X,
                    0.4f,
                    0.0f,
                )
                zoomX.interpolator = OvershootInterpolator()
                zoomX.duration = 500L
                zoomX.doOnEnd { screen.remove() }

                val zoomY = ObjectAnimator.ofFloat(
                    screen.iconView,
                    View.SCALE_Y,
                    0.4f,
                    0.0f,
                )
                zoomY.interpolator = OvershootInterpolator()
                zoomY.duration = 500L
                zoomY.doOnEnd { screen.remove() }

                zoomX.start()
                zoomY.start()
            }
        }
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
