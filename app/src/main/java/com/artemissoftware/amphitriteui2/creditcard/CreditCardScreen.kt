package com.artemissoftware.amphitriteui2.creditcard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui2.creditcard.composables.CreditCard

@Composable
fun CreditCardScreen() {

    LazyColumn(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(CreditCardInfo.mockCreditCards) { card ->
            CreditCard(cardInfo = card)
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun CreditCardScreenPreview() {
    CreditCardScreen()
}