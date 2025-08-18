package com.example.bottonbarjc

sealed class Screens(val route:String){
    data object Home:Screens("home")
    data object Search:Screens("search")
    data object Notification:Screens("notification")
    data object Profile:Screens("profile")
    data object Post:Screens("post")
}
