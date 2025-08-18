package com.example.learnnavdrawer

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learnnavdrawer.ui.theme.GreenJC
import com.example.learnnavdrawer.ui.theme.LearnNavDrawerTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LearnNavDrawerTheme {
                LearnNavDrawer()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearnNavDrawer() {
    val navigationController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current.applicationContext

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Box(
                    modifier = Modifier
                        .background(GreenJC)
                        .fillMaxSize()
                        .height(150.dp)
                ) {
                    Text(text = "Drawer Header", color = Color.White, modifier = Modifier.padding(16.dp))
                }
                Divider()
                NavigationDrawerItem(
                    label = { Text(text = "Home", color = GreenJC) },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "Home", tint = GreenJC) },
                    onClick = {
                        coroutineScope.launch { drawerState.close() }
                        navigationController.navigate(Screens.Home.Screen) { popUpTo(0) }
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Profile", color = GreenJC) },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Default.Person, contentDescription = "Profile", tint = GreenJC) },
                    onClick = {
                        coroutineScope.launch { drawerState.close() }
                        navigationController.navigate(Screens.Profile.Screen) { popUpTo(0) }
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Settings", color = GreenJC) },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Default.Settings, contentDescription = "Settings", tint = GreenJC) },
                    onClick = {
                        coroutineScope.launch { drawerState.close() }
                        navigationController.navigate(Screens.Settings.Screen) { popUpTo(0) }
                    }
                )
                NavigationDrawerItem(
                    label = { Text(text = "Logout", color = GreenJC) },
                    selected = false,
                    icon = { Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "Logout", tint = GreenJC) },
                    onClick = {
                        coroutineScope.launch { drawerState.close() }
                        Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show()
                    }
                )
            }
        }
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text(text = "WhatsApp") },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = GreenJC,
                        titleContentColor = Color.White
                    ),
                    navigationIcon = {
                        IconButton(onClick = { coroutineScope.launch { drawerState.open() } }) {
                            Icon(Icons.Rounded.Menu, contentDescription = "MenuBar", tint = Color.White)
                        }
                    }
                )
            }
        ) { paddingValues ->
            NavHost(
                navController = navigationController,
                startDestination = Screens.Home.Screen,
                modifier = Modifier.padding(paddingValues)
            ) {
                composable(Screens.Home.Screen) { Text("Home Screen") }
                composable(Screens.Profile.Screen) { Text("Profile Screen") }
                composable(Screens.Settings.Screen) { Text("Settings Screen") }
            }
        }
    }
}

@Preview
@Composable
fun Prevision () {
    LearnNavDrawerTheme {
        LearnNavDrawer()
    }

}


