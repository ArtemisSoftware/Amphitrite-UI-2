package com.artemissoftware.amphitriteui2.animations.waterbottle

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui2.animations.waterbottle.composables.WatterBottle
import com.artemissoftware.amphitriteui2.ui.theme.Black10

@Composable
fun WaterBottleScreen() {
    var usedWaterAmount by remember { mutableIntStateOf(100) }
    val totalWaterAmount = remember { 1000 }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Black10)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        WatterBottle(
            modifier = Modifier
                .width(200.dp)
                .height(480.dp),
            totalWaterAmount = totalWaterAmount,
            unit = "ml",
            usedWaterAmount = usedWaterAmount,
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Total Amount is : $totalWaterAmount",
            textAlign = TextAlign.Center,
        )
        Button(
            onClick = {
                when{
                    usedWaterAmount + 200 >= totalWaterAmount -> usedWaterAmount = totalWaterAmount
                    usedWaterAmount < totalWaterAmount -> usedWaterAmount += 200
                    else -> usedWaterAmount = totalWaterAmount
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xff279EFF)),
        ) {
            Text(text = "Drink")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun WaterBottleScreenPreview() {
    WaterBottleScreen()
}
