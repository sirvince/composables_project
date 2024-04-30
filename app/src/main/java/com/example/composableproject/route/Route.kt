package com.example.composableproject.route

sealed class Route {
    data class SplashScreen(val name: String = "Splash Screen") : Route()
    data class LoginScreen(val name: String = "Login") : Route()
    data class SignUpScreen(val name: String = "Sign up") : Route()
}