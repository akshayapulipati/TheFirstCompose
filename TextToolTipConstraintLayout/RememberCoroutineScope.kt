package com.example.thefirstcompose

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun CoroutineScopeComposable() {
    val counter = remember { mutableStateOf(0) }
    val scope = rememberCoroutineScope()

    var text = "Counter is running ${counter.value}"
    if (counter.value == 10) {
        text = "Counter stopped"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = text)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            scope.launch {
                Log.d("CoroutineScopeComposable", "Started...")
                try {
                    for (i in 1..10) {
                        counter.value++
                        delay(1000)
                    }
                } catch (e: Exception) {
                    Log.d(
                        "CoroutineScopeComposable",
                        "Exception: ${e.message.toString()}"
                    )
                }
            }
        }) {
            Text(text = "Start")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoroutineScopeComposablePreview() {
    MaterialTheme {
        CoroutineScopeComposable()
    }
}
