package com.artemissoftware.amphitriteui2.categoriestable.models

data class CategoryTransaction(
    val amount: String,
    val percentage: Int, // 0..+100
){

    companion object{
        val mock = CategoryTransaction(amount = "100", percentage = 30)

        val mockList = listOf(CategoryTransaction(amount = "100", percentage = 30), CategoryTransaction(amount = "200", percentage = 70))
    }

}