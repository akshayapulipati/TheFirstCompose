package com.example.bottonbarjc

import android.provider.ContactsContract.Profile
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.bottonbarjc.ui.theme.GreenJC

@Composable
fun Profile(modifier: Modifier = Modifier) {
    Box(modifier= Modifier.fillMaxSize()){
        Column(modifier= Modifier
            .fillMaxSize()
            .align(Alignment.Center),
            verticalArrangement= Arrangement.Center,
            horizontalAlignment= Alignment.CenterHorizontally){
            Text(text="Profile", fontSize = 30.sp, color = GreenJC)

        }
    }

}