package com.artemissoftware.amphitriteui2

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.artemissoftware.amphitriteui2.dragdrop.DragDropViewModel
import com.artemissoftware.amphitriteui2.multiplescreens.rememberWindowSize
import com.artemissoftware.amphitriteui2.stopwatch.StopWatchViewModel
import com.artemissoftware.amphitriteui2.ui.theme.AmphitriteUI2Theme
import com.getbouncer.cardscan.ui.CardScanActivity
import com.getbouncer.cardscan.ui.CardScanActivityResult
import com.getbouncer.cardscan.ui.CardScanActivityResultHandler
import dagger.hilt.android.AndroidEntryPoint
import io.card.payment.CardIOActivity

val API_KEY = "qOJ_fF-WLDMbG05iBq5wvwiTNTmM2qIn"

@AndroidEntryPoint
class MainActivity : ComponentActivity(), CardScanActivityResultHandler {

    private val dragDropViewModel = DragDropViewModel()
    private val stopWatchViewModel = StopWatchViewModel()
    private val mainViewModel by viewModels<MainViewModel>()

    val MY_SCAN_REQUEST_CODE = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !mainViewModel.state.value.isReady
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

        // --onCardIoScanPress()
        // --creditCardOrc(this)
//        CardScanActivity.warmUp(
//            context = this,
//            apiKey = API_KEY,
//            initializeNameAndExpiryExtraction = true
//        )

        setContent {
            val state = mainViewModel.state.collectAsState().value
            val navController = rememberNavController()

            DisposableEffect(navController) {
                val observer = LifecycleEventObserver { _, event ->
                    if (event == Lifecycle.Event.ON_CREATE) {
                        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
                            mainViewModel.onTriggerEvent(MainEvent.ThemeChange(route = destination.route))
                        }
                        navController.addOnDestinationChangedListener(listener)

                        onDispose {
                            navController.removeOnDestinationChangedListener(listener)
                        }
                    }
                }

                lifecycle.addObserver(observer)

                onDispose {
                    lifecycle.removeObserver(observer)
                }
            }

            AmphitriteUI2Theme(themeType = state.theme) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    val window = rememberWindowSize()
                    SetupNavGraph(
                        navController = navController,
                        window = window,
                        dragDropViewModel = dragDropViewModel,
                        stopWatchViewModel = stopWatchViewModel,
                    )
                }
            }
        }
    }

    fun creditCardOrc(mainActivity: MainActivity) {
        CardScanActivity.start(
            activity = mainActivity,
            apiKey = API_KEY,
            enableEnterCardManually = true,

            // expiry extraction is in beta. See the comment below.
            enableExpiryExtraction = true,

            // name extraction is in beta. See the comment below.
            enableNameExtraction = true,
        )
    }

    fun onCardIoScanPress() {
        val scanIntent = Intent(this, CardIOActivity::class.java)

        // customize these values to suit your needs.
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, true) // default: false
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_CVV, false) // default: false
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_POSTAL_CODE, false) // default: false

        // MY_SCAN_REQUEST_CODE is arbitrary and is only used within this activity.
        startActivityForResult(scanIntent, MY_SCAN_REQUEST_CODE)
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (CardScanActivity.isScanResult(requestCode)) {
//            CardScanActivity.parseScanResult(resultCode, data, this)
//        }
//    }

    override fun analyzerFailure(scanId: String?) {
        TODO("Not yet implemented")
    }

    override fun cameraError(scanId: String?) {
        TODO("Not yet implemented")
    }

    override fun canceledUnknown(scanId: String?) {
        TODO("Not yet implemented")
    }

    override fun cardScanned(scanId: String?, scanResult: CardScanActivityResult) {
        TODO("Not yet implemented")
    }

    override fun enterManually(scanId: String?) {
        TODO("Not yet implemented")
    }

    override fun userCanceled(scanId: String?) {
        TODO("Not yet implemented")
    }
}
