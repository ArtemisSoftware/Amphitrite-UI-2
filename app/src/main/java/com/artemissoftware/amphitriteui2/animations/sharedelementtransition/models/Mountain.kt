package com.artemissoftware.amphitriteui2.animations.sharedelementtransition.models

data class Mountain(
    val title: String,
    val description: String,
    val image: String,
) {

    companion object {
        val mockMountains = listOf(
            Mountain(
                title = "Gray and Brown Mountain",
                description = "The artwork \"Mountains against the stormy sky\" portrays a dramatic landscape that captures the raw power and beauty of nature. The painting depicts a mountain range in the foreground, with jagged peaks and rugged cliffs rendered in shades of brown and gray",
                image = "https://shorturl.at/hjHV0",
            ),
            Mountain(
                title = "Mountains Covered in Snow",
                description = "The highest mountain in Australia, Mount Kosciuszko, is in the Snowy Mountains. It reaches a height of 7,310 feet (2,228 meters). The Snowy Mountains were originally called Muniong (Munyang). Now only the northeastern part of the range is called by that name.",
                image = "https://shorturl.at/lvF02",
            ),
            Mountain(
                title = "Black and Teal Mountain",
                description = "This entry-level bike is an excellent choice for a rider that just wants to get out and experience mountain biking and the outdoors on a versatile and reliable",
                image = "https://shorturl.at/aDS17",
            ),
        )
    }
}
