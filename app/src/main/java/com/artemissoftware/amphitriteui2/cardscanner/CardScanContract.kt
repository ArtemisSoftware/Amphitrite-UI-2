package com.artemissoftware.amphitriteui2.cardscanner

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.activity.result.contract.ActivityResultContract
import com.artemissoftware.amphitriteui2.API_KEY
import com.artemissoftware.amphitriteui2.MainActivity
import com.getbouncer.cardscan.ui.CardScanActivity
import com.getbouncer.cardscan.ui.CardScanActivity.Companion.RESULT_SCANNED_CARD
import com.getbouncer.cardscan.ui.CardScanActivityResult
import com.getbouncer.scan.framework.Config.displayLogo

class CardScanContract : ActivityResultContract<MainActivity, CardScanActivityResult?>() {
    override fun createIntent(context: Context, input: MainActivity): Intent {
        val scanIntent = CardScanActivity.buildIntent(
            context = input,
            apiKey = API_KEY,
            enableEnterCardManually = true,
            enableExpiryExtraction = true,
            enableNameExtraction = true,
        )
        return scanIntent!!.apply {
            displayLogo = false
        }
    }

    override fun parseResult(resultCode: Int, intent: Intent?): CardScanActivityResult? {
        var card: CardScanActivityResult? = null

        intent?.let {
            intent.extras?.let {
                card = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                    it.getParcelable(RESULT_SCANNED_CARD, CardScanActivityResult::class.java)
                } else {
                    it.getParcelable(RESULT_SCANNED_CARD)
                }
            }
        }

        return card
    }
}
