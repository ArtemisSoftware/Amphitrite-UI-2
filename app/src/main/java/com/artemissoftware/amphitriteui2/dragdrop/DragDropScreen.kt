package com.artemissoftware.amphitriteui2.dragdrop

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui2.dragdrop.composables.DragTarget
import com.artemissoftware.amphitriteui2.dragdrop.composables.DragableScreen
import com.artemissoftware.amphitriteui2.dragdrop.composables.DropItem
import com.artemissoftware.amphitriteui2.dragdrop.composables.PersonBox
import com.artemissoftware.amphitriteui2.dragdrop.composables.PlaceHolder
import com.artemissoftware.amphitriteui2.dragdrop.models.Person

@Composable
fun DragDropScreen(mainViewModel: DragDropViewModel) {
    DragableScreen(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(0.8f)),
    ) {
        DragDropScreenContent(mainViewModel)
    }
}

@Composable
private fun DragDropScreenContent(
    mainViewModel: DragDropViewModel,
) {
    val state = mainViewModel.state.collectAsState().value
    val screenWidth = LocalConfiguration.current.screenWidthDp

    var anim by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            state.items.forEach { person ->
                DragTarget(
                    dataToDrop = person,
                    onStartDragging = {
                        mainViewModel.startDragging()
                    },
                    onStopDragging = {
                        anim = false
                        mainViewModel.stopDragging()
                    },
                    content = {
                        PersonBox(person = person, screenWidth = screenWidth)
                    },
                )
            }
        }

        AnimatedVisibility(
            visible = state.isCurrentlyDragging,
            enter = slideInHorizontally(initialOffsetX = { it }),
        ) {
            DropItem<Person>(
                modifier = Modifier
                    .size(Dp(screenWidth / 3.5f)),
                content = { isInBound, personItem ->

                    if (personItem != null) {
                        LaunchedEffect(key1 = personItem) {
                            mainViewModel.addPerson(personItem)
                        }
                    }

                    PlaceHolder(isInBound = isInBound)
                },
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 30.dp),
            contentAlignment = Alignment.Center,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .padding(bottom = 100.dp),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Text(
                    text = "Added Persons",
                    color = Color.White,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Start,
                )
                state.addedPersons.forEach { person ->
                    Text(
                        text = person.name,
                        color = Color.White,
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold,
                    )
                }
            }
        }
    }
}
