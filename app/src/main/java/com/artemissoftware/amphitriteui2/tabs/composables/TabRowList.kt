package com.artemissoftware.amphitriteui2.tabs.composables

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.amphitriteui2.tabs.models.TabPageInfo
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.PagerState
import com.google.accompanist.pager.pagerTabIndicatorOffset
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class)
@Composable
fun TabRowList(
    tabs: List<TabPageInfo>,
    pagerState: PagerState,
    scope: CoroutineScope
) {

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Color(0xFF2E5894),
        contentColor = Color(0xFFBCD4E6),
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                modifier = Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }) {
        tabs.forEachIndexed { index, tab ->
            // OR Tab()
            LeadingIconTab(
                icon = {
                    Icon(
                        painter = painterResource(id = tab.icon),
                        contentDescription = ""
                    )
                },
                text = { Text(tab.title) },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
@Preview(showBackground = true)
private fun TabRowPreview() {
    TabRowList(
        tabs = listOf(TabPageInfo.Books,TabPageInfo.Music),
        pagerState = rememberPagerState(),
        scope = rememberCoroutineScope()
    )
}