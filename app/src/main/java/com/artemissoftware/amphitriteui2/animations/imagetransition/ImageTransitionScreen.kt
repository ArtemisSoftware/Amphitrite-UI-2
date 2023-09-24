package com.artemissoftware.amphitriteui2.animations.imagetransition

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui2.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageTransitionScreen() {
    val images = remember {
        mutableListOf(
            R.drawable.beach_1,
            R.drawable.beach_2,
            R.drawable.beach_3,
        )
    }

    val colorMatrix = remember {
        ColorMatrix()
    }

    val pagerState = rememberPagerState()

    Scaffold(modifier = Modifier.padding(vertical = 48.dp)) {
        HorizontalPager(
            count = images.size,
            state = pagerState,
            modifier = Modifier.padding(it),
        ) { index ->
            ImageTransition(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                image = images[index],
                colorMatrix = colorMatrix,
                pageOffset = (pagerState.currentPage - index) + pagerState.currentPageOffset,
            )
        }
    }
}

@Preview
@Composable
private fun ImageTransitionScreenPreview() {
    ImageTransitionScreen()
}
