package com.artemissoftware.amphitriteui2.categoriestable.models

import kotlin.random.Random


data class Categories(
    val categories: List<Category>,
    val months: List<String>,
    val categoriesByMonth: List<CategoryMonth>,
){

    companion object{

        fun mock(numberOfResults: Int) : Categories{
            return Categories(

                months = List(numberOfResults) { "Month $it" },


                categories = List(numberOfResults) {
                    Category(
                        label = "Category $it",
                        percentage = Random.nextInt(0, 100)
                    )
                },
                categoriesByMonth = List(numberOfResults) {
                    CategoryMonth(
                        List(numberOfResults) {
                            CategoryTransaction(
                                amount = Random.nextInt(
                                    10,
                                    400
                                ).toString(),
                                percentage = Random.nextInt(0, 100)
                            )
                        }
                    )
                }


            )
        }


    }


}
