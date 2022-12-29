package com.artemissoftware.amphitriteui2.creditcard.composables

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.amphitriteui2.creditcard.CreditCardInfo
import com.artemissoftware.amphitriteui2.ui.theme.SpaceGrotesk
import com.artemissoftware.amphitriteui2.ui.theme.SpaceMono

@Composable
fun CreditCardBack(
    cardInfo: CreditCardInfo,
    animateBack: Float,
    rotation: Float
) {

        Image(
            painter = painterResource(id = cardInfo.backgroundDrawable),
            contentDescription = "Card Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )
        Box(modifier = Modifier.padding(16.dp)) {

            Column(
                modifier = Modifier.padding(top = 10.dp),
            ) {

                Divider(
                    modifier = Modifier
                        .graphicsLayer {
                            alpha = animateBack
                        },
                    color = Color.Black,
                    thickness = 50.dp
                )

                Text(
                    text = cardInfo.cvv,
                    color = Color.Black,
                    modifier = Modifier
                        .padding(10.dp)
                        .background(Color.White)
                        .fillMaxWidth()
                        .graphicsLayer {
                            alpha = animateBack
                            rotationY = rotation
                        }
                        .padding(10.dp),
                    fontFamily = SpaceMono,
                    letterSpacing = 1.2.sp,
                    fontSize = 16.sp,
                    textAlign = TextAlign.End
                )

                Text(
                    text = cardInfo.cardDeveloper,
                    color = Color.White,
                    modifier = Modifier
                        .fillMaxWidth()
                        .graphicsLayer {
                            alpha = animateBack
                            rotationY = rotation
                        }
                        .padding(5.dp),
                    fontFamily = SpaceGrotesk,
                    letterSpacing = 1.2.sp,
                    fontSize = 10.sp,
                    textAlign = TextAlign.Center
                )
            }


    }

}

@Composable
@Preview(showBackground = true)
private fun CreditCardBackPreview() {

    Card(
        modifier = Modifier
            .height(220.dp),
        shape = RoundedCornerShape(14.dp),
        elevation = 8.dp
    ) {
        val animateBack by animateFloatAsState(
            targetValue =  0f,
            animationSpec = tween(500)
        )

        val rotation by animateFloatAsState(
            targetValue =  0f,
            animationSpec = tween(500)
        )
        CreditCardBack(
            cardInfo = CreditCardInfo.mockCreditCards[0],
            animateBack = animateBack,
            rotation = rotation
        )
    }
}