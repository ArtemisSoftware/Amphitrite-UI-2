package com.artemissoftware.amphitriteui2.dragdrop.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui2.dragdrop.models.Person

@Composable
fun PersonBox(
    person: Person,
    screenWidth: Int,
) {
    Box(
        modifier = Modifier
            .size(Dp(screenWidth / 5f))
            .clip(RoundedCornerShape(15.dp))
            .shadow(5.dp, RoundedCornerShape(15.dp))
            .background(person.backgroundColor, RoundedCornerShape(15.dp)),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = person.name,
            style = MaterialTheme.typography.body1,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
        )
    }
}
