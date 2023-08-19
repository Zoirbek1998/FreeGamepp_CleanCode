package uz.telecom.freegamepp.presentation.free_game.state

import uz.telecom.freegamepp.domain.model.FreeGames

data class FreeGameState (
    val freeGames: List<FreeGames>? = emptyList(),
    val errorMsg:String? = "",
    val isLoading:Boolean = false
)