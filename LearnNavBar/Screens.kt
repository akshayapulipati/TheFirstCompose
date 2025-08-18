package com.example.learnnavdrawer
//means it has pre defined sub classes
sealed class Screens(val Screen:String){
    //each object represents a specific screen in application
    data object Home:Screens("home")
    data object Profile:Screens("profile")
    data object Settings:Screens("settings")
}