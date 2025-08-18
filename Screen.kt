package com.example.thefirstcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun BlogPreview() {
    LazyColumn {
        items(getCategoryList().size) { index ->
            val item = getCategoryList()[index]
            BlogCategory(img = item.img, title = item.title, subtitle = item.subtitle)
        }
        //    Column(modifier=Modifier.verticalScroll(rememberScrollState())){
//        getCategoryList().map{item ->
//            BlogCategory(img=item.img, title = item.title, subtitle = item.subtitle)
//        }
//    }

    }
}

@Composable
fun BlogCategory(img: Int, title: String, subtitle: String) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = img),
                contentDescription = null,
                modifier = Modifier
                    .size(48.dp)
                    .padding(end = 8.dp)
            )
            ForReuse(title, subtitle, Modifier.fillMaxWidth())
        }
    }
}

@Composable
private fun ForReuse(title: String, subtitle: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Text(
            text = subtitle,
            fontWeight = FontWeight.Thin,
            fontSize = 12.sp
        )
    }
}

data class Category(val img: Int, val title: String, val subtitle: String)

fun getCategoryList(): MutableList<Category> {
    val list = mutableListOf<Category>()
    list.add(Category(R.drawable.b, "Programming", "Learn different languages"))
    list.add(Category(R.drawable.b, "UI/UX Design", "Design beautiful interfaces"))
    list.add(Category(R.drawable.b, "Data Science", "Analyze and visualize data"))
    list.add(Category(R.drawable.b, "Mobile Development", "Build Android and iOS apps"))
    list.add(Category(R.drawable.b, "Web Development", "Create websites and web apps"))
    list.add(Category(R.drawable.b, "Cybersecurity", "Protect systems and data"))
    list.add(Category(R.drawable.b, "Game Development", "Make fun and interactive games"))
    list.add(Category(R.drawable.b, "Cloud Computing", "Deploy apps to the cloud"))
    list.add(Category(R.drawable.b, "AI & Machine Learning", "Build smart applications"))
    list.add(Category(R.drawable.b, "DevOps", "Automate and improve workflows"))
    return list
}
