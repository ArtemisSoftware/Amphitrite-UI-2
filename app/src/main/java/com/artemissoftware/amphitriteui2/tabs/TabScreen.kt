package com.artemissoftware.amphitriteui2.tabs

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.amphitriteui2.tabs.composables.TabRowList
import com.artemissoftware.amphitriteui2.tabs.composables.TabsContent
import com.artemissoftware.amphitriteui2.tabs.models.TabPageInfo
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabScreen() {

    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TabRowList(
            tabs = TabPageInfo.mockList,
            pagerState = pagerState,
            scope = coroutineScope
        )
        TabsContent(
            tabs = TabPageInfo.mockList,
            pagerState = pagerState
        )
    }

}

@Composable
@Preview(showBackground = true)
private fun TabScreenPreview() {
    TabScreen()
}