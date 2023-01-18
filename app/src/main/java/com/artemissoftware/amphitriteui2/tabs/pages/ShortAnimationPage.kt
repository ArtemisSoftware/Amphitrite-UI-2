package com.artemissoftware.amphitriteui2.tabs.pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui2.animations.shorts.ButtonClickAnimation
import com.artemissoftware.amphitriteui2.animations.shorts.HeartClickAnimation

@Composable
fun ShortAnimationPage() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        
        Text(text = "Short click Animations")

        Spacer(modifier = Modifier.height(height = 36.dp))
        
        ButtonClickAnimation()

        Spacer(modifier = Modifier.height(height = 36.dp))

        HeartClickAnimation()
    }
}