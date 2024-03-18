package com.ads.pethub.controller

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ads.pethub.screens.HomeScreen
import com.ads.pethub.screens.LoginScreen
import com.ads.pethub.screens.PetFinderScreen
import com.ads.pethub.screens.PetProfileScreen
import com.ads.pethub.screens.RegisterPetRecordScreen
import com.ads.pethub.screens.RegisterPetScreen
import com.ads.pethub.viewModel.HomeViewModel
import com.ads.pethub.viewModel.LoginViewModel
import com.ads.pethub.viewModel.PetFinderViewModel
import com.ads.pethub.viewModel.PetProfileViewModel
import com.ads.pethub.viewModel.RegisterPetRecordViewModel
import com.ads.pethub.viewModel.RegisterPetViewModel

@Composable
fun AppController(
) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login",
        exitTransition = {
            slideOutOfContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.End,
                tween(480)
            ) + fadeOut(animationSpec = tween(360))
        },
        enterTransition = {
            slideIntoContainer(
                towards = AnimatedContentTransitionScope.SlideDirection.Start,
                tween(480)
            )
        }
    ) {
        // ROTA: LOGIN
        composable(route = "login") {
            LoginScreen(
                navController = navController,
                viewModel = LoginViewModel()
            )
        }

        // ROTA: HOME
        composable(route = "home/{userId}") {
            val user = it.arguments?.getLong("userId", 999)
            HomeScreen(
                navController = navController,
                viewModel = HomeViewModel(),
                userId = user!!
            )
        }

        // ROTA: PET PROFILE
        composable(
            route = "petProfile/{userId}/{petId}",
            arguments = listOf(
                navArgument("userId") {
                    type = NavType.LongType
                },
                navArgument("petId") {
                    type = NavType.LongType
                }
            )
        ) {
            val user: Long? = it.arguments?.getLong("userId")
            val pet: Long? = it.arguments?.getLong("petId", 999)
            PetProfileScreen(
                navController = navController,
                viewModel = PetProfileViewModel(),
                userId = user!!,
                petId = pet!!
            )
        }

        // ROTA: REGISTER PET RECORD
        composable(
            route = "registerPetRecord/{userId}/{petId}",
            arguments = listOf(
                navArgument("userId") {
                    type = NavType.LongType
                },
                navArgument("petId") {
                    type = NavType.LongType
                }
            )
        ) {
            val user: Long? = it.arguments?.getLong("userId")
            val pet: Long? = it.arguments?.getLong("petId", 999)
            RegisterPetRecordScreen(
                navController = navController,
                viewModel = RegisterPetRecordViewModel(),
                userId = user!!,
                petId = pet!!
            )
        }

        // ROTA: REGISTER PET
        composable(route = "registerPet/{userId}") {
            val user = it.arguments?.getLong("userId")
            RegisterPetScreen(
                navController = navController,
                userId = user!!,
                viewModel = RegisterPetViewModel()
            )
        }

        // ROTA: PET FINDER
        composable(route = "petFinder/{userId}") {
            val user = it.arguments?.getLong("userId")
            PetFinderScreen(
                navController = navController,
                viewModel = PetFinderViewModel(),
                userId = user!!
            )
        }
    }
}