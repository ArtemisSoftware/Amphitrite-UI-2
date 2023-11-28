package com.artemissoftware.amphitriteui2.animations.sharedelementtransition

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.artemissoftware.amphitriteui2.animations.sharedelementtransition.models.Mountain
import com.skydoves.orbital.Orbital

@Composable
fun MountainListScreen() {
    Orbital {
        LazyColumn(modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.surface)) {
            items(
                items = Mountain.mockMountains,
                key = { it.title },
            ) { mountain ->

                var expanded by rememberSaveable {
                    mutableStateOf(false)
                }

                AnimatedVisibility(
                    visibleState = remember { MutableTransitionState(false) }.apply { targetState = true },
                    enter = fadeIn(tween(durationMillis = 300)),
                    exit = fadeOut(tween(durationMillis = 300)),
                ) {

                }
            }
        }
    }
}
