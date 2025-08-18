package com.example.thefirstcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview(showBackground = true,widthDp =300,heightDp = 500)
@Composable
private fun ModifierPreview() {
    Text(text = "Hello",
        color = Color.White,
        modifier =Modifier.clickable {  }
            .background(Color.Blue)
            .size(200.dp)
            .border(4.dp,Color.Red)
            .clip(CircleShape)
            .background(Color.Yellow))

}