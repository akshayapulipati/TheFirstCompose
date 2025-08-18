package com.example.learnnavdrawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.learnnavdrawer.ui.theme.GreenJC
import com.example.learnnavdrawer.ui.theme.LearnNavDrawerTheme

@Composable
fun Settings() {
    Box(modifier = Modifier.fillMaxSize()){
        Column(modifier = Modifier
            .fillMaxSize()
            .align(Alignment.Center),
            verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text ="Settings", fontSize = 30.sp, color = GreenJC)
        }
    }

}

@Preview
@Composable
fun SettingsPreview() {
    LearnNavDrawerTheme {
        Home()
    }

}