package com.artemissoftware.amphitriteui2.tabs.models

import com.artemissoftware.amphitriteui2.R


sealed class TabPageInfo(
    val icon: Int,
    val title: String
    ) {
    object Music : TabPageInfo(icon = R.drawable.ic_music, title = "Music")
    object Movies : TabPageInfo(icon = R.drawable.ic_movie,  title = "Movies")
    object Books : TabPageInfo(icon = R.drawable.ic_book,  title = "Books")
}