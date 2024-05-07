package com.example.composableproject


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composableproject.route.Route
import com.example.composableproject.presentation.login.LoginScreen
import com.example.composableproject.presentation.member.MemberListScreen
import com.example.composableproject.presentation.member_profile.MemberProfile
import com.example.composableproject.presentation.menu.MenuScreen
import com.example.composableproject.screen.PolicyScreen
import com.example.composableproject.screen.PrivacyScreen
import com.example.composableproject.presentation.sign_up.SignUpScreen
import com.example.composableproject.screen.SplashScreen
import com.example.composableproject.ui.theme.ComposableProjectTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposableProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Navigation()
                }
            }
        }
    }
}

@Composable
fun Navigation(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Route.MenuScreen().name){
        composable(Route.MenuScreen().name){
            MenuScreen(navController = navController)
        }

        composable(Route.MemberProfileScreen().name){
            MemberProfile(navController = navController)
        }

        composable(Route.MemberListScreen().name){
            MemberListScreen(navController = navController)
        }

        composable(Route.SplashScreen().name){
            SplashScreen(navController = navController)
        }
        composable(Route.LoginScreen().name){
            LoginScreen(navController = navController)
        }
        composable(Route.PrivacyScreen().name){
            PrivacyScreen(navController = navController)
        }
        composable(Route.PolicyScreen().name){
            PolicyScreen(navController = navController)
        }
        composable(Route.SignUpScreen().name){
            SignUpScreen(navController = navController)
        }
    }
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}



