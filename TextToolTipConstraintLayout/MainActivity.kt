package com.example.thefirstcompose

import android.os.Bundle
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thefirstcompose.ui.theme.TheFirstComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TheFirstComposeTheme {
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                )
                {
TextInput()
                }
            }
        }
    }
}

@Composable
fun TextInput(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }

    TextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        label = { Text(text = "Enter Message") },
        modifier = modifier
    )
}

@Composable
fun ListView(imgId:Int,name:String,occupation:String) {
    Row{
            Image(painter = painterResource(id=imgId),
        contentDescription="",
        Modifier.size(40.dp)
            )
        Column(){
            Text(
                text =name,
                fontWeight= FontWeight.Bold
            )
            Text(
                text =occupation,
                fontWeight=FontWeight.Thin,
                fontSize = 12.sp
            )
        }
    }
    
}
@Preview(showBackground = true)
@Composable
fun ListViewPreview() {
    TheFirstComposeTheme {
        Column {
            ListView(R.drawable.a, "Akshaya", "Software Engineer")
            ListView(R.drawable.a, "Akshaya", "Software Engineer")
            ListView(R.drawable.a, "Akshaya", "Software Engineer")
            ListView(R.drawable.a, "Akshaya", "Software Engineer")
        }
    }
}
@Preview(showBackground = true)
@Composable
private fun PreviewFunction() {
    TheFirstComposeTheme {
        TextInput()
    }
}

