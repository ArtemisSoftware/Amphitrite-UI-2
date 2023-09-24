package com.artemissoftware.amphitriteui2.animations.imagetransition

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ColorMatrix
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.artemissoftware.amphitriteui2.R

@Composable
fun ImageTransition(
    @DrawableRes image: Int,
    colorMatrix: ColorMatrix,
    pageOffset: Float,
    modifier: Modifier = Modifier,
) {
    val imageSize = animateFloatAsState(
        targetValue = if (pageOffset != 0.0f) 0.95f else 1f,
        animationSpec = tween(
            durationMillis = 300,
        ),
        label = "",
    ).value

    LaunchedEffect(key1 = imageSize) {
        if (pageOffset != 0.0f) {
            colorMatrix.setToScale(1f, 1f, 1f, 0.8f)
        } else {
            colorMatrix.setToScale(1f, 1f, 1f, 1f)
        }
    }

    AsyncImage(
        model = ImageRequest
            .Builder(LocalContext.current)
            .data(image)
            .build(),
        contentDescription = "Image",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .graphicsLayer {
                scaleX = imageSize
                scaleY = imageSize
            }
            .clip(RoundedCornerShape(16.dp)),
        colorFilter = ColorFilter.colorMatrix(colorMatrix),
    )
}

@Preview
@Composable
private fun ImageTransitionPreview() {
    ImageTransition(
        image = R.drawable.beach_1,
        colorMatrix = ColorMatrix(),
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        pageOffset = 0.3F,
    )
}
