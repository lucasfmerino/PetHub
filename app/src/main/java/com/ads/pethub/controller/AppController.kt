package com.ads.pethub.controller

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ads.pethub.screens.HomeScreen
import com.ads.pethub.screens.PetFinderScreen
import com.ads.pethub.screens.PetProfileScreen
import com.ads.pethub.screens.RegisterPetRecordScreen
import com.ads.pethub.screens.RegisterPetScreen

@Composable
fun AppController() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "home",
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
        // ROTA: HOME
        composable(route = "home") {
            HomeScreen(navController = navController)
        }

        // ROTA: PET PROFILE
        composable(route = "{userId}/petProfile/{petId}") {
            val user = it.arguments?.getInt("userId")
            val pet = it.arguments?.getInt("petId")
            PetProfileScreen(
                navController = navController,
                userId = user!!,
                petId = pet!!
            )
        }

        // ROTA: REGISTER PET RECORD
        composable(route = "{userId}/registerPetRecord") {
            val user = it.arguments?.getInt("userId")
            RegisterPetRecordScreen(
                navController = navController,
                userId = user!!
            )
        }

        // ROTA: REGISTER PET
        composable(route = "{userId}/registerPet") {
            val user = it.arguments?.getInt("userId")
            RegisterPetScreen(
                navController = navController,
                userId = user!!
            )
        }

        // ROTA: PET FINDER
        composable(route = "{userId}/petFinder") {
            val user = it.arguments?.getInt("userId")

            PetFinderScreen(
                navController = navController,
                userId = user!!
            )
        }
    }
}