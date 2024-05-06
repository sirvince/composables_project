package com.example.composableproject.route

sealed class Route {
    data class SplashScreen(val name: String = "Splash Screen") : Route()
    data class LoginScreen(val name: String = "Login") : Route()
    data class SignUpScreen(val name: String = "Sign up") : Route()
    data class PrivacyScreen(val name: String = "Privacy Screen") : Route()
    data class PolicyScreen(val name: String = "Policy Screen") : Route()

    data class MenuScreen(val name: String = "Menu Screen") : Route()
    data class MemberListScreen(val name: String = "Member List Screen") : Route()
}