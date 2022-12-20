package com.artemissoftware.amphitriteui2.islands

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui2.islands.composables.DemoIsland1
import com.artemissoftware.amphitriteui2.islands.composables.DemoIsland2
import com.artemissoftware.amphitriteui2.islands.composables.DemoIsland3
import com.artemissoftware.amphitriteui2.islands.models.IslandType

@Composable
fun Island() {

    var selectedIsland by remember {
        mutableStateOf(IslandType.DOT)
    }

    Box(
        modifier = Modifier
            .padding(12.dp)
            .clip(RoundedCornerShape(16.dp))
//            .background(Color.LightGray)
            .defaultMinSize(16.dp, 16.dp)
            .animateContentSize()
            .wrapContentHeight()
            .clickable {
                selectedIsland = sequence(selectedIsland)
            },
        contentAlignment = Alignment.Center
    ) {

        when(selectedIsland){
            IslandType.TEXT -> DemoIsland1()
            IslandType.IMAGE -> DemoIsland2()
            IslandType.DOT -> DemoIsland3()
        }

    }

}


private fun sequence(islandType: IslandType) : IslandType{

    return when(islandType){
        IslandType.DOT -> IslandType.IMAGE
        IslandType.IMAGE -> IslandType.TEXT
        IslandType.TEXT -> IslandType.DOT
    }

}



@Preview(showBackground = true)
@Composable
private fun IslandPreview() {
    Island()
}