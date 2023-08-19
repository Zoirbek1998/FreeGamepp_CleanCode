package uz.telecom.freegamepp.presentation.free_game.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.telecom.freegamepp.core.common.Resource
import uz.telecom.freegamepp.domain.usecase.FreeGameUseCase
import uz.telecom.freegamepp.presentation.free_game.state.FreeGameState
import uz.telecom.freegamepp.presentation.free_game.state.UiEffect
import uz.telecom.freegamepp.presentation.free_game.state.UiEvent
import javax.inject.Inject

@HiltViewModel
class FreeGameViewModel @Inject constructor(private val useCase: FreeGameUseCase) : ViewModel() {
    private val _freeGameState = MutableStateFlow(FreeGameState())
    val freeGameState: StateFlow<FreeGameState> get() = _freeGameState

    private val _uiEffect = MutableSharedFlow<UiEffect>()

    val uiEffect: SharedFlow<UiEffect> get() = _uiEffect.asSharedFlow()


    init {
        getAllFreeGames()
    }

   private fun getAllFreeGames() = useCase()
        .onEach {
            when (it) {
                is Resource.Error -> {
                    _freeGameState.value = FreeGameState().copy(errorMsg = it.msg)
                    _uiEffect.emit(UiEffect.ShowSnackBar(it.msg.toString()))
                }

                is Resource.Loaging -> {
                    _freeGameState.value = FreeGameState().copy(isLoading = true)
                }

                is Resource.Success -> {
                    _freeGameState.value = FreeGameState().copy(freeGames = it.data)
                }
            }
        }
        .launchIn(viewModelScope)


    fun omEvent(uiEvent: UiEvent) {
        when (uiEvent) {
            UiEvent.NavigateToDetailScreen -> {

            }
        }
    }
}