package com.artemissoftware.amphitriteui2.creditcard.composables

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui2.creditcard.CreditCardInfo

@Composable
fun CreditCard(cardInfo: CreditCardInfo) {

    var rotated by remember { mutableStateOf(false) }

    val rotation by animateFloatAsState(
        targetValue = if (rotated) 180f else 0f,
        animationSpec = tween(500)
    )

    val animateFront by animateFloatAsState(
        targetValue = if (!rotated) 1f else 0f,
        animationSpec = tween(500)
    )

    val animateBack by animateFloatAsState(
        targetValue = if (rotated) 1f else 0f,
        animationSpec = tween(500)
    )


    Card(
        modifier = Modifier
            .height(220.dp)
            .graphicsLayer {
                rotationY = rotation
                cameraDistance = 8 * density
            }
            .clickable {
                rotated = !rotated
            },
        shape = RoundedCornerShape(14.dp),
        elevation = 8.dp,

    ) {
        if (!rotated) {
            CreditCardFront(
                cardInfo = cardInfo,
                animateFront = animateFront
            )
        }
        else{
            CreditCardBack(
                cardInfo = cardInfo,
                animateBack = animateBack,
                rotation = rotation
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun CreditCardPreview() {
    CreditCard(CreditCardInfo.mockCreditCards[0])
}