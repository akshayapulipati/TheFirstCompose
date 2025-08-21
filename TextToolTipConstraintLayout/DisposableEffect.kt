package com.example.thefirstcompose

import android.util.Log
import android.view.ViewTreeObserver
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsCompat.Type

@Composable
fun App() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        KeyboardComposable()
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = "",
            onValueChange = {}
        )
    }
}

@Composable
fun KeyboardComposable() {
    val view = LocalView.current

    DisposableEffect(key1 = Unit) {
        val listener = ViewTreeObserver.OnGlobalLayoutListener {
            val insets = ViewCompat.getRootWindowInsets(view)
            val isKeyboardVisible = insets?.isVisible(Type.ime()) ?: false
            Log.d("CHEEZYCODE", isKeyboardVisible.toString())
        }

        view.viewTreeObserver.addOnGlobalLayoutListener(listener)

        onDispose {
            view.viewTreeObserver.removeOnGlobalLayoutListener(listener)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun KeyboardComposablePreview() {
    MaterialTheme {
        App()
    }
}


// How this works:
//
//LocalView.current → gets the current Android view.
//
//DisposableEffect → attaches a listener and removes it automatically when composable leaves composition.
//
//ViewCompat.getRootWindowInsets(view) → gets system insets.
//
//isVisible(Type.ime()) → checks if keyboard (IME) is visible.
//
//Logs true when keyboard is shown, false when hidden.
