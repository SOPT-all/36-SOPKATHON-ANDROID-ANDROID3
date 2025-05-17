package org.sopt.a36_sopkathon_android_android3.presentation.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.sopt.a36_sopkathon_android_android3.presentation.dongmin.DongminRoute
import org.sopt.a36_sopkathon_android_android3.presentation.jiwoo.JiwooRoute
import org.sopt.a36_sopkathon_android_android3.presentation.juwan.JuwanRoute
import org.sopt.a36_sopkathon_android_android3.presentation.minseo.MinseoRoute

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navController,
            startDestination = "juwan"
        ) {
            composable(route = "minseo") {
                MinseoRoute(
                    navigateToJiwoo = { navController.navigateToJiwoo() }
                )
            }

            composable(route = "dongmin") {
                DongminRoute(
                    navigateToMinseo = { navController.navigateToJiwoo() }
                )
            }

            composable(route = "jiwoo") {
                JiwooRoute(
                    navigateToJuwan = { navController.navigateToJuwan() }
                )
            }

            composable(route = "juwan") {
                JuwanRoute(
                    navigateToDongmin = { navController.navigateToDongmin() },
                    navigateToScrap = { navController.navigateToMinseo() },
                )
            }
        }
    }
}
