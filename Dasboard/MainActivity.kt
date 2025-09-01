package com.example.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

                DashboardApp()

        }
    }
}

@Composable
fun DashboardApp() {
    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar(containerColor = Color.White) {
                NavigationBarItem(
                    selected = selectedIndex == 0,
                    onClick = { selectedIndex = 0 },
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1 },
                    icon = { Icon(Icons.Default.ShoppingCart, contentDescription = "Cart") },
                    label = { Text("Cart") }
                )
                NavigationBarItem(
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2 },
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Profile") }
                )
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            DashboardScreen()
        }
    }
}

@Composable
fun DashboardScreen() {
    Column(
        Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF2F2F2)), // Light grey background
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        ConstraintLayout {
            val (redBoarder) = createRefs()
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .constrainAs(redBoarder) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .background(color = Color(0xFFE23744)) // Zomato Red
            )
            Row(
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp, end = 24.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Zomato",
                    color = Color.White,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic
                )
                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clickable {}
                )
            }
        }

        //  Search Bar
        var searchText by rememberSaveable { mutableStateOf("") }
        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            label = { Text(text = "Search restaurants...") },
            trailingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.search),
                    contentDescription = null,
                    modifier = Modifier
                        .size(30.dp)
                        .padding(end = 6.dp)
                )
            },
            shape = RoundedCornerShape(50.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(24.dp)
                .shadow(3.dp, shape = RoundedCornerShape(50.dp))
        )

        //  Banner Section
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
                .shadow(5.dp, shape = RoundedCornerShape(25.dp))
                .height(150.dp)
                .background(color = Color(0xFFE23744), shape = RoundedCornerShape(25.dp))
        ) {
            val (bannerImage) = createRefs()
            Image(
                painter = painterResource(id = R.drawable.bannerimg),
                contentDescription = null,
                modifier = Modifier.constrainAs(bannerImage) {
                    top.linkTo(parent.top)
                    bottom.linkTo(parent.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                }
            )
        }

        //  Categories Section
        Text(
            text = "CATEGORIES",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.padding(start = 16.dp, top = 16.dp, bottom = 8.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            CategoryItem(R.drawable.cake, "Cake")
            CategoryItem(R.drawable.biryani, "Biryani")
            CategoryItem(R.drawable.burger, "Burger")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            CategoryItem(R.drawable.noodles, "Noodles")
            CategoryItem(R.drawable.pasta, "Pasta")
            CategoryItem(R.drawable.icecream, "Ice Cream")
        }
    }
}

@Composable
fun CategoryItem(imageRes: Int, title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = title,
            modifier = Modifier
                .size(80.dp)
                .shadow(4.dp, shape = CircleShape)
                .background(Color.White, CircleShape)
                .padding(8.dp)
        )
        Text(text = title, fontWeight = FontWeight.Medium, fontSize = 14.sp)
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DashboardPreview() {

        DashboardApp()

}

