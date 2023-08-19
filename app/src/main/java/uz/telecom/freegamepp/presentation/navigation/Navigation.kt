package uz.telecom.freegamepp.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.coroutines.flow.collectLatest
import uz.telecom.freegamepp.presentation.free_game.components.GameScreen
import uz.telecom.freegamepp.presentation.free_game.state.UiEffect
import uz.telecom.freegamepp.presentation.free_game.viewModel.FreeGameViewModel

import uz.telecom.freegamepp.presentation.navigation.screen.Screen


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(navController: NavHostController) {
    val snackBarHostState = remember {
        SnackbarHostState()
    }

    Scaffold(snackbarHost = { SnackbarHost(hostState = snackBarHostState) }) {
        NavHost(navController = navController, startDestination = Screen.GameScreen.route) {
            composable(Screen.GameScreen.route) {
                val freeGameViewModel = hiltViewModel<FreeGameViewModel>()
                val state = freeGameViewModel.freeGameState.collectAsStateWithLifecycle()
                GameScreen(freeGameState = state.value, modifier = Modifier)


                LaunchedEffect(key1 = true) {
                    freeGameViewModel.uiEffect.collectLatest {
                        when (it) {
                            UiEffect.NavigateToDetailScreen -> TODO()
                            is UiEffect.ShowSnackBar -> {
                                snackBarHostState.showSnackbar(it.msg)
                            }
                        }
                    }
                }
            }
        }
    }

}