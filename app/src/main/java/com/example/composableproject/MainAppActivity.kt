package com.example.composableproject


import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.composableproject.presentation.application.action.return_application.ReturnApplication
import com.example.composableproject.presentation.application.application_details.ApplicationListScreen
import com.example.composableproject.presentation.application.application_list.ApplicationDetailsScreen
import com.example.composableproject.route.Route
import com.example.composableproject.presentation.login.LoginScreen
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
    NavHost(navController = navController, startDestination = Route.ApplicationListScreen().name){
        composable(Route.MenuScreen().name){
            MenuScreen(navController = navController)
        }

        composable(Route.ReturnApplicationScreen().name){
            ReturnApplication()
        }
        composable(Route.ApplicationListScreen().name){
            ApplicationListScreen(navController = navController)
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
        composable(Route.ApplicationDetailScreen().name,
            arguments = listOf(navArgument("applicationId") { type = NavType.IntType }))
        {backStackEntry ->
            val applicationId = backStackEntry.arguments?.getInt("applicationId")
            ApplicationDetailsScreen(navController = navController)
        }
    }
    HandleBackButton(navController)
}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}


@Composable
fun HandleBackButton(navController: NavHostController) {
    val context = LocalContext.current

    BackHandler {
        val currentRoute = navController.currentBackStackEntry?.destination?.route

        when (currentRoute) {
            Route.MenuScreen().name, -> {
                (context as? Activity)?.finish()
            }
            Route.LoginScreen().name -> {
                // Finish the activity when back is pressed on the LoginScreen
                (context as? Activity)?.finish()
            }
            else -> {
                // Default back navigation
                navController.popBackStack()
            }
        }
    }
}

