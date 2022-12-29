package com.artemissoftware.amphitriteui2.creditcard

import com.artemissoftware.amphitriteui2.R

data class CreditCardInfo(
    val cardNumber: String,
    val cardHolder: String,
    val providerDrawable: Int,
    val backgroundDrawable: Int,
    val cvv: String,
    val cardDeveloper: String,
    val validity: String
){

    companion object{



        val mockCreditCards = listOf(
            CreditCardInfo(
                backgroundDrawable = R.drawable.card_mesh,
                providerDrawable = R.drawable.master_card,
                cardNumber = "8547 9658 6325 4521",
                cardHolder = "Jim Hopper",
                cvv = "212",
                cardDeveloper = "ArtemisCards",
                validity = "11/12"
            ),
            CreditCardInfo(
                backgroundDrawable = R.drawable.card_mesh_2,
                providerDrawable = R.drawable.visa,
                cardNumber = "6582 4521 3256 8522",
                cardHolder = "Steve Harrington",
                cvv = "112",
                cardDeveloper = "ArtemisExpress",
                validity = "01/29"
            ),
            CreditCardInfo(
                backgroundDrawable = R.drawable.card_mesh_3,
                providerDrawable = R.drawable.visa,
                cardNumber = "9856 7452 2569 7413",
                cardHolder = "Joyce Byers",
                cvv = "123",
                cardDeveloper = "ArtemisGoldCards",
                validity = "15/22"
            )
        )
    }

}