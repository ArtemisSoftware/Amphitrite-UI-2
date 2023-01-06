package com.artemissoftware.amphitriteui2.multiplescreens.composables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.artemissoftware.amphitriteui2.multiplescreens.WindowSize
import com.artemissoftware.amphitriteui2.multiplescreens.WindowType
import com.artemissoftware.amphitriteui2.multiplescreens.models.CustomData


@Composable
fun RowScope.RowContent(
    data: CustomData,
    windowSize: WindowSize,
    maxLines: Int
) {
    val showIcons by remember(key1 = windowSize) {
        mutableStateOf(windowSize.width == WindowType.Expanded)
    }

    AsyncImage(
        modifier = Modifier
            .weight(1f),
        model = ImageRequest.Builder(LocalContext.current)
            .data(data = data.image)
            .crossfade(enable = true)
            .build(),
        contentDescription = "Image",
        contentScale = ContentScale.Crop
    )

    Column(modifier = Modifier.weight(1f)) {
        Text(
            text = data.title,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontSize =
                when (windowSize.width) {
                    WindowType.Expanded -> MaterialTheme.typography.h2.fontSize
                    WindowType.Medium -> MaterialTheme.typography.h5.fontSize
                    else -> MaterialTheme.typography.h6.fontSize
                },
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(
            modifier = Modifier.alpha(ContentAlpha.disabled),
            text = data.description,
            maxLines = maxLines,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                fontSize =
                when (windowSize.width) {
                    WindowType.Expanded -> MaterialTheme.typography.h5.fontSize
                    WindowType.Medium -> MaterialTheme.typography.h6.fontSize
                    else -> MaterialTheme.typography.body1.fontSize
                }
            )
        )
        if (showIcons) {
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                data.icons.forEach {
                    Icon(
                        modifier = Modifier.size(40.dp),
                        imageVector = it,
                        contentDescription = "Icon"
                    )
                }
            }
        }
    }
}