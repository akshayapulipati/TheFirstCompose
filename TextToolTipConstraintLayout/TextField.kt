package com.example.thefirstcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BasicTextFieldExample() {
    var text by remember { mutableStateOf("") } // state to store text

    TextField(
        value = text,
        onValueChange = { text = it },  // updates text when user types
        label = { Text("Enter your name") }   // hint/label
    )
}

@Composable
fun OutlinedTextFieldExample() {
    var email by remember { mutableStateOf("") }
//Shows a border around the field.
    OutlinedTextField(
        value = email,
        onValueChange = { email = it },
        label = { Text("Email") },
        placeholder = { Text("example@email.com") }
    )
}

@Composable
fun TextFieldWithIcons() {
    var password by remember { mutableStateOf("") }

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Password") },
        //leadingIcon → icon on the left.
        leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "Lock") },
        //trailingIcon → icon on the right.
        trailingIcon = { Icon(Icons.Default.Visibility, contentDescription = "Show/Hide") }
    )
}

@Composable
fun PasswordTextField() {
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text("Password") },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val image = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
            IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                Icon(image, contentDescription = null)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTextFields() {
    Column {
        BasicTextFieldExample()
        OutlinedTextFieldExample()
        TextFieldWithIcons()
        PasswordTextField()
    }
}
