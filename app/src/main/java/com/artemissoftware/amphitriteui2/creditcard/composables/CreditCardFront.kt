package com.artemissoftware.amphitriteui2.creditcard.composables

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.amphitriteui2.creditcard.CreditCardInfo
import com.artemissoftware.amphitriteui2.ui.theme.SpaceGrotesk
import com.artemissoftware.amphitriteui2.ui.theme.SpaceMono

@Composable
fun CreditCardFront(
    cardInfo: CreditCardInfo,
    animateFront: Float
) {


    Image(
        painter = painterResource(id = cardInfo.backgroundDrawable),
        contentDescription = "Card Background",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxSize()
    )
    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = cardInfo.providerDrawable),
            contentDescription = "Visa",
            modifier = Modifier
                .width(86.dp)
                .align(Alignment.TopStart)
                .graphicsLayer {
                    alpha = animateFront
                }
        )

        Text(
            text = cardInfo.cardNumber,
            fontFamily = SpaceMono,
            letterSpacing = 1.2.sp,
            fontSize = 25.sp,
            modifier = Modifier
                .align(Alignment.Center)
                .graphicsLayer {
                    alpha = animateFront
                }
        )


        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
        ) {
            Text(
                text = "Card Holder",
                fontFamily = SpaceMono,
                letterSpacing = 1.2.sp,
                fontSize = 9.sp,
                modifier = Modifier
                    .graphicsLayer {
                        alpha = animateFront
                    }
            )
            Text(
                text = cardInfo.cardHolder,
                fontFamily = SpaceGrotesk,
                letterSpacing = 1.1.sp,
                fontSize = 16.sp,
                modifier = Modifier
                    .graphicsLayer {
                        alpha = animateFront
                    }
            )
        }

        Column(modifier = Modifier.align(Alignment.BottomEnd)) {
            Text(
                text = "VALID THRU",
                fontFamily = SpaceMono,
                letterSpacing = 1.2.sp,
                fontSize = 9.sp,
                modifier = Modifier
                    .graphicsLayer {
                        alpha = animateFront
                    }
            )
            Text(
                text = cardInfo.validity,
                fontFamily = SpaceGrotesk,
                letterSpacing = 1.1.sp,
                fontSize = 15.sp,
                modifier = Modifier
                    .graphicsLayer {
                        alpha = animateFront
                    }
            )
        }
    }



}

@Composable
@Preview(showBackground = true)
private fun CreditCardFrontPreview() {

    Card(
        modifier = Modifier
            .height(220.dp),
    ) {
        val animateFront by animateFloatAsState(
        targetValue =  0f,
        animationSpec = tween(500)
        )
        CreditCardFront(
            cardInfo = CreditCardInfo.mockCreditCards[0],
            animateFront = animateFront
        )
    }
}