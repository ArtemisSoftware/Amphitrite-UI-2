package com.artemissoftware.amphitriteui2.cardscanner

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui2.MainActivity

@Composable
fun CardScannerScreen() {
    var cardIoResult by remember {
        mutableStateOf("")
    }
    var cardScanResult by remember {
        mutableStateOf("")
    }

    val launcherCardIo = rememberLauncherForActivityResult(contract = CardIoContract()) {
        cardIoResult = it ?: "falhou"
    }

    val launcherCardScanner = rememberLauncherForActivityResult(contract = CardScanContract()) {
        cardScanResult = it.toString() ?: "falhou"
    }

    val activity = LocalContext.current as Activity

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Button(
            onClick = {
                launcherCardIo.launch("LOLO")
            },
            content = {
                Text(text = "Card io")
            },
        )

        Text(text = "Card IO result: $cardIoResult")

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                launcherCardScanner.launch(activity as MainActivity)
            },
            content = {
                Text(text = "Card Scan")
            },
        )

        Text(text = "Card Scan result: $cardScanResult")
    }
}

fun Context.getActivity(): ComponentActivity? = when (this) {
    is ComponentActivity -> this
    is ContextWrapper -> baseContext.getActivity()
    else -> null
}
