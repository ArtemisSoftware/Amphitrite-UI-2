package com.artemissoftware.amphitriteui2.motionlayout.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui2.draggable.DraggableBox

@Composable
fun ExampleContent() {

    val startHeightNum = 300

    Box(
        modifier = Modifier
            .layoutId("body")
            .fillMaxWidth()
            .background(Color.White)
    ){
        //content, not necessarily scrollable or list
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ){
            items(200, key = {it}){
                Box(
                    modifier = Modifier
                        .padding(24.dp)
                        .fillMaxWidth()
                        .background(
                            Color.White,
                            RoundedCornerShape(12.dp)
                        )
                        .border(
                            BorderStroke(
                                2.dp,
                                Color.Gray
                            ),
                            RoundedCornerShape(12.dp)
                        )
                        .padding(50.dp),
                    contentAlignment = Alignment.Center
                ){
                    Text(it.toString())
                }
            }
        }
    }


    Box(
        modifier = Modifier
            .layoutId("header")
            .fillMaxWidth()
            .height(startHeightNum.dp)
            .background(Color.Gray)
    )

    Box(
        modifier = Modifier
            .layoutId("content1")
            .aspectRatio(1f)
            .border(BorderStroke(4.dp,Color.Red), CircleShape)
            .padding(8.dp)
            .background(Color.Blue, CircleShape)
    )

    Text(
        "Numbers",
        color = Color.White,
        modifier = Modifier
            .layoutId("content2")
    )
}

@Preview(showBackground = true)
@Composable
private fun DraggableBoxPreview() {
    ExampleContent()
}