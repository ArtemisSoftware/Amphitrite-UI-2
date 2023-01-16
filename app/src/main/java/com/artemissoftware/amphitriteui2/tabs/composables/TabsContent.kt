package com.artemissoftware.amphitriteui2.tabs.composables

import androidx.compose.runtime.Composable
import com.artemissoftware.amphitriteui2.tabs.models.TabPageInfo
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabsContent(tabs: List<TabPageInfo>, pagerState: PagerState) {
    HorizontalPager(state = pagerState, count = tabs.size) { page ->
        tabs[page].screen(tabs[page])
    }
}