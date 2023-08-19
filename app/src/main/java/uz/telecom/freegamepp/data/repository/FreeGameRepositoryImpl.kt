package uz.telecom.freegamepp.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import uz.telecom.freegamepp.core.common.Resource
import uz.telecom.freegamepp.data.remote.FreeGameApi
import uz.telecom.freegamepp.data.remote.mapper.toDomainFreeGames
import uz.telecom.freegamepp.domain.model.FreeGames
import uz.telecom.freegamepp.domain.repository.FreeGameRepository
import java.lang.Exception
import javax.inject.Inject

class FreeGameRepositoryImpl @Inject constructor(private val freeGameApi: FreeGameApi) : FreeGameRepository {

    override fun getFreeGames(): Flow<Resource<List<FreeGames>>> = flow {
        emit(Resource.Loaging())
        try {
            val result = freeGameApi.getFreeGame().map {
                it.toDomainFreeGames()
            }
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error(e.message.toString()))
        }
    }.catch {
        emit(Resource.Error(it.message.toString()))

    }.flowOn(Dispatchers.IO)

}