package com.artemissoftware.amphitriteui2.cardscanner

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import io.card.payment.CardIOActivity
import io.card.payment.CreditCard

class CardIoContract : ActivityResultContract<String, String?>() {
    val DATA = "data"
    val INPUT_DATA = "input_data"

    override fun createIntent(context: Context, input: String): Intent {
        val scanIntent = Intent(context, CardIOActivity::class.java)

        // customize these values to suit your needs.
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, true) // default: false
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_CVV, false) // default: false
        scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_POSTAL_CODE, false) // default: false
        // MY_SCAN_REQUEST_CODE is arbitrary and is only used within this activity.
        // startActivityForResult(scanIntent, MY_SCAN_REQUEST_CODE)

        // ----

//        val intent = Intent(context, DummyResultActivity::class.java)
//        intent.putExtra(INPUT_DATA, input)
        return scanIntent
    }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        var resultDisplayStr = ""

        if (intent != null && intent.hasExtra(CardIOActivity.EXTRA_SCAN_RESULT)) {
            val scanResult = intent.getParcelableExtra<CreditCard>(CardIOActivity.EXTRA_SCAN_RESULT)

            // Never log a raw card number. Avoid displaying it, but if necessary use getFormattedCardNumber()
            resultDisplayStr = "Card Number: " + scanResult!!.redactedCardNumber + "\n"

            // Do something with the raw number, e.g.:
            // myService.setCardNumber( scanResult.cardNumber );
            if (scanResult.isExpiryValid) {
                resultDisplayStr += "Expiration Date: " + scanResult.expiryMonth + "/" + scanResult.expiryYear + "\n"
            }
            if (scanResult.cvv != null) {
                // Never log or display a CVV
                resultDisplayStr += "CVV has " + scanResult.cvv.length + " digits.\n"
            }
            if (scanResult.postalCode != null) {
                resultDisplayStr += "Postal Code: " + scanResult.postalCode + "\n"
            }
        } else {
            resultDisplayStr = "Scan was canceled."
        }
        return resultDisplayStr
//        return when (resultCode) {
//            //Transforming our result to required format before returning it
//            Activity.RESULT_OK -> intent?.getStringExtra(DATA)
//            else -> null
//        }
    }
}
