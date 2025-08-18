package com.example.thefirstcompose

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.thefirstcompose.ui.theme.GreenJC

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun LearnTopAppBar() {
    val context = LocalContext.current

    TopAppBar(
        title = { Text(text = "WhatsApp") },
        navigationIcon = {
            IconButton(onClick = {
                Toast.makeText(context, "WhatsApp Icon", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.whatsapp),
                    contentDescription = "Whatsapp Icon"
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = GreenJC,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        ),
        actions = {
            IconButton(onClick = {
                Toast.makeText(context, "Profile Clicked", Toast.LENGTH_SHORT).show()
            }) {
                Icon(imageVector = Icons.Filled.Person, contentDescription = "Profile")
            }

            IconButton(onClick = {
                Toast.makeText(context, "Search Clicked", Toast.LENGTH_SHORT).show()
            }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "Search")
            }

            IconButton(onClick = {
                Toast.makeText(context, "More Options Clicked", Toast.LENGTH_SHORT).show()
            }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "More Options")
            }
        }
    )
}
