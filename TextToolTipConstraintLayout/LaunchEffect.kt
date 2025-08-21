package com.example.thefirstcompose

import android.util.Log
import androidx.compose.foundation.layout.Button
import androidx.compose.foundation.layout.Text
import androidx.compose.runtime.*

@Composable
fun Counter() {
    var count = remember { mutableStateOf(0) }
    var key = count.value % 3

    LaunchedEffect(key1 = key) {
        Log.d("Counter", "Current count: ${count.value}")
    }

    Button(onClick = { count.value++ }) {
        Text(text = "Increment count")
    }
}
@Preview(showBackground = true)
@Composable
fun CounterPreview() {
    MaterialTheme {
        Counter()
    }
}


//🔎 Explanation:
//
//remember { mutableStateOf(0) } → Creates a state variable to hold the counter value.
//
//key = count.value % 3 → Side effect will re-run only when count is divisible by 3 (0, 3, 6…).
//
//LaunchedEffect(key1 = key) → Runs when key changes.
//
//Log.d("Counter", "...") → Prints the counter value to Logcat.
//
//Button → Increments count.value when clicked.