package dev.janfher.tallerjapunhabaenero

import UserList
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun NavHostController() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable(route = "home") {
            HomePlace(navController)
        }
        composable(route = "userlist") {
            UserList(navController)
        }
        composable(
            route = "param/{contactName}",
            arguments = listOf(navArgument("contactName") { type = NavType.StringType })
        ) { backStackEntry ->
            val contactName = backStackEntry.arguments?.getString("contactName") ?: ""
            ParamScreen(navController, contactName)
        }
        composable(route = "menu") {
            MenuScreen(navController)
        }
    }
}
