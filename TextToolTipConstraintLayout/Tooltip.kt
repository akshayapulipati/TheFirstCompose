package com.example.thefirstcompose


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview


@OptIn(ExperimentalMaterial3Api::class) // Tooltip API is experimental
@Composable
fun TooltipExample() {
    // Create and remember tooltip state
    val tooltipState = remember { TooltipState() }

    TooltipBox(
        state = tooltipState, // required state
        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
        tooltip = {
            PlainTooltip {
                Text("This is a tooltip")
            }
        }
    ) {
        IconButton(onClick = { /* Do something */ }) {
            Icon(
                imageVector = Icons.Default.Info,
                contentDescription = "Info"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTooltip() {
    MaterialTheme {
        TooltipExample()
    }
}
