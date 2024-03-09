package com.ads.pethub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ads.pethub.screens.HomeScreen
import com.ads.pethub.screens.PetFinderScreen
import com.ads.pethub.screens.PetProfileScreen
import com.ads.pethub.screens.RegisterPetRecordScreen
import com.ads.pethub.screens.RegisterPetScreen
import com.ads.pethub.ui.theme.PetHubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PetHubTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

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
                        composable(route = "home") {
                            HomeScreen(navController = navController)
                        }

                        composable(route = "{userId}/petProfile/{petId}") {
                            val user = it.arguments?.getInt("userId")
                            val pet = it.arguments?.getInt("petId")

                            PetProfileScreen(
                                navController = navController,
                                userId = user!!,
                                petId = pet!!
                            )
                        }

                        composable(route = "{userId}/registerPetRecord") {
                            val user = it.arguments?.getInt("userId")

                            RegisterPetRecordScreen(
                                navController = navController,
                                userId = user!!

                            )
                        }

                        composable(route = "{userId}/registerPet") {
                            val user = it.arguments?.getInt("userId")

                            RegisterPetScreen(
                                navController = navController,
                                userId = user!!
                            )
                        }

                        composable(route = "{userId}/petFinder") {
                            val user = it.arguments?.getInt("userId")

                            PetFinderScreen(
                                navController = navController,
                                userId = user!!
                                )
                        }
                    }
                }
            }
        }
    }
}
