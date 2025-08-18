package com.example.bottonbarjc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bottonbarjc.ui.theme.BottonBarJCTheme
import com.example.bottonbarjc.ui.theme.GreenJC

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BottonBarJCTheme {
                MyBottomAppBar()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBottomAppBar(modifier: Modifier = Modifier) {
    val navigationController = rememberNavController()
    val selected = remember { mutableStateOf(Icons.Default.Home) }
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            BottomAppBar(containerColor = GreenJC) {
                // Home Button
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Home
                        navigationController.navigate(Screens.Home.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Home,
                        contentDescription = "Home",
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Home) Color.White else Color.DarkGray
                    )
                }

                // Search Button
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Search
                        navigationController.navigate(Screens.Search.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Search",
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Search) Color.White else Color.DarkGray
                    )
                }

                // Center FAB
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    FloatingActionButton(
                        onClick = { showBottomSheet = true },
                        containerColor = Color.White
                    ) {
                        Icon(
                            Icons.Default.Add,
                            contentDescription = "Add",
                            tint = GreenJC
                        )
                    }
                }

                // Notifications
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Notifications
                        navigationController.navigate(Screens.Notification.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Notifications,
                        contentDescription = "Notification",
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Notifications) Color.White else Color.DarkGray
                    )
                }

                // Profile
                IconButton(
                    onClick = {
                        selected.value = Icons.Default.Person
                        navigationController.navigate(Screens.Profile.route) {
                            popUpTo(0)
                        }
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Person,
                        contentDescription = "Profile",
                        modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Person) Color.White else Color.DarkGray
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navigationController,
            startDestination = Screens.Home.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Screens.Home.route) { Home() }
            composable(Screens.Search.route) { Search() }
            composable(Screens.Notification.route) { Notification() }
            composable(Screens.Profile.route) { Profile() }
            composable(Screens.Post.route) { Post() } // Added Post screen
        }
    }

    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                BottomSheetItem(
                    icon = Icons.Default.ThumbUp,
                    title = "Create A Post",
                    onClick = {
                        showBottomSheet = false
                        navigationController.navigate(Screens.Post.route) {
                            popUpTo(0)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun BottomSheetItem(
    icon: ImageVector,
    title: String,
    onClick: () -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier
            .clickable { onClick() }
            .padding(12.dp)
    ) {
        Icon(
            icon,
            contentDescription = null,
            tint = GreenJC,
            modifier = Modifier.size(28.dp)
        )
        Text(
            text = title,
            color = GreenJC,
            fontSize = 20.sp
        )
    }
}
