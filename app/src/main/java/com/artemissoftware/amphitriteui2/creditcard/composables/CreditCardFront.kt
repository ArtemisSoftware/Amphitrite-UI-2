package com.artemissoftware.amphitriteui2.creditcard.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.amphitriteui2.creditcard.CreditCardInfo
import com.artemissoftware.amphitriteui2.ui.theme.SpaceGrotesk
import com.artemissoftware.amphitriteui2.ui.theme.SpaceMono

@Composable
fun CreditCardFront(cardInfo: CreditCardInfo) {

    Card(
        modifier = Modifier
            .height(220.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp
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
            )

            Text(
                text = cardInfo.cardNumber,
                fontFamily = SpaceMono,
                letterSpacing = 1.2.sp,
                fontSize = 25.sp,
                modifier = Modifier
                    .align(Alignment.Center)
            )


            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
            ) {
                Text(
                    text = "Card Holder",
                    fontFamily = SpaceMono,
                    letterSpacing = 1.2.sp,
                    fontSize = 9.sp
                )
                Text(
                    text = cardInfo.cardHolder,
                    fontFamily = SpaceGrotesk,
                    letterSpacing = 1.1.sp,
                    fontSize = 16.sp
                )
            }

            Column(modifier = Modifier.align(Alignment.BottomEnd)) {
                Text(
                    text = "VALID THRU",
                    fontFamily = SpaceMono,
                    letterSpacing = 1.2.sp,
                    fontSize = 9.sp
                )
                Text(
                    text = cardInfo.validity,
                    fontFamily = SpaceGrotesk,
                    letterSpacing = 1.1.sp,
                    fontSize = 15.sp
                )
            }
        }

    }

}

@Composable
@Preview(showBackground = true)
private fun CreditCardFrontPreview() {
    CreditCardFront(
        cardInfo = CreditCardInfo.mockCreditCards[0]
    )
}