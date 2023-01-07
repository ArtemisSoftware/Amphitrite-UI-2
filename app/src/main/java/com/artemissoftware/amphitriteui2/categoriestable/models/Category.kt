package com.artemissoftware.amphitriteui2.categoriestable.models

data class Category(
    val label: String,
    val percentage: Int, // 0..+100
){

    companion object{

        val mock = Category(label = "My category", percentage = 10)

    }

}
