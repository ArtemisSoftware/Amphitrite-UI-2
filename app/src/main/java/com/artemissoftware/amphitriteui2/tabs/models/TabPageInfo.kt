package com.artemissoftware.amphitriteui2.tabs.models

import androidx.compose.runtime.Composable
import com.artemissoftware.amphitriteui2.R
import com.artemissoftware.amphitriteui2.tabs.pages.TabPage

sealed class TabPageInfo(
    val icon: Int,
    val title: String,
    val screen: @Composable (TabPageInfo) -> Unit
    ) {
    object Music : TabPageInfo(icon = R.drawable.ic_music, title = "Music", screen = { info-> TabPage(info = info) })
    object Movies : TabPageInfo(icon = R.drawable.ic_movie,  title = "Movies", screen = { info-> TabPage(info = info) })
    object Books : TabPageInfo(icon = R.drawable.ic_book,  title = "Books", screen = { info-> TabPage(info = info) })

    companion object{

        val mockList = listOf<TabPageInfo>(Music, Movies, Books)

    }
}
