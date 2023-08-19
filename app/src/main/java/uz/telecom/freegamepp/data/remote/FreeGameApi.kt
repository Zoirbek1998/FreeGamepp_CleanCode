package uz.telecom.freegamepp.data.remote

import retrofit2.http.GET
import uz.telecom.freegamepp.data.remote.dto.FreeGameDto

interface FreeGameApi {

    @GET("games")
    suspend fun getFreeGame():List<FreeGameDto>
}