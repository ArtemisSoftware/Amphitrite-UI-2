package com.artemissoftware.amphitriteui2.categoriestable.models

data class CategoryTransaction(
    val amount: String,
    val percentage: Int, // 0..+100
)