package com.example.composableproject.route

sealed class Route {
    data class SplashScreen(val name: String = "SplashScreen") : Route()
    data class LoginScreen(val name: String = "Login") : Route()
    data class SignUpScreen(val name: String = "Signup") : Route()
    data class PrivacyScreen(val name: String = "PrivacyScreen") : Route()
    data class PolicyScreen(val name: String = "PolicyScreen") : Route()
    data class MenuScreen(val name: String = "MenuScreen") : Route()
    data class ApplicationListScreen(val name: String = "ApplicationListScreen") : Route()
    data class ApplicationDetailScreen(val name: String = "applicationDetailScreen/{applicationId}") : Route()
    data class ReturnApplicationScreen(val name: String = "ReturnApplication") : Route()
}