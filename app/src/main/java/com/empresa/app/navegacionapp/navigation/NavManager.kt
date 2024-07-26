package com.empresa.app.navegacionapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.empresa.app.navegacionapp.views.DetailView
import com.empresa.app.navegacionapp.views.HomeView

@Composable
fun NavManager(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home" ){
        composable("Home"){
            HomeView(navController)
        }
        composable("Detail/{id}/?{opcional}", arguments = listOf(

            navArgument("id"){
                type = NavType.IntType
            },
            navArgument("opcional"){
                type = NavType.StringType
            },

        )){
            // se coloca el ? porque puede er un valor opcional
            val id = it.arguments?.getInt("id") ?: 0
            val opcional = it.arguments?.getString("opcional") ?: ""
            DetailView(navController,id,opcional)
        }



    }

}
