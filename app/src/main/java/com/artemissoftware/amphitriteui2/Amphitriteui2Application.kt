package com.artemissoftware.amphitriteui2

import android.app.Application
import com.getbouncer.cardscan.ui.CardScanActivity
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class Amphitriteui2Application : Application() {

    override fun onCreate() {
        super.onCreate();

        /*
         * CardScan will attempt to update the ML models used to scan payment
         * cards. By placing the call to the `warmUp` method in the
         * `onApplicationCreate` method of your app, you allow the most time
         * possible for models to upgrade. Note that `warmUp` processes on a
         * background thread and will not affect your app's startup time.
         *
         * Note: the last parameter, `initializeNameAndExpiryExtraction`,
         * determines if name and expiry extraction (beta feature) should be
         * turned on.
         */
        CardScanActivity.warmUp(
            context = this,
            apiKey = API_KEY,
            initializeNameAndExpiryExtraction = true
        )
    }
}
