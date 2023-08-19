package uz.telecom.freegamepp.domain.repository

import kotlinx.coroutines.flow.Flow
import uz.telecom.freegamepp.core.common.Resource
import uz.telecom.freegamepp.domain.model.FreeGames

interface FreeGameRepository {
    fun getFreeGames() : Flow<Resource<List<FreeGames>>>
}