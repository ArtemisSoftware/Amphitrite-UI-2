package com.artemissoftware.amphitriteui2.islands.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.amphitriteui2.R

@Composable
fun DemoIsland1() {
    Text(
        modifier = Modifier
            .padding(
                horizontal = 24.dp,
                vertical = 12.dp
            ),
        text = "I am the first island",
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    )
}

@Composable
fun DemoIsland2() {

    val image: Painter = painterResource(id = R.drawable.aquarius)
    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp),
        painter = image,
        contentScale = ContentScale.Crop,
        contentDescription = ""
    )
}

@Composable
fun DemoIsland3() {

    Box(
       modifier = Modifier
           .size(12.dp)
           .clip(CircleShape)
           .background(Color.Red)

    )
}




@Preview(showBackground = true)
@Composable
private fun DemoIsland1Preview() {
    DemoIsland1()
}

@Preview(showBackground = true)
@Composable
private fun DemoIsland2Preview() {
    DemoIsland2()
}

@Preview(showBackground = true)
@Composable
private fun DemoIsland3Preview() {
    DemoIsland3()
}