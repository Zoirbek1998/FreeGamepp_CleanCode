package uz.telecom.freegamepp.data.remote.mapper

import uz.telecom.freegamepp.data.remote.dto.FreeGameDto
import uz.telecom.freegamepp.domain.model.FreeGames

fun FreeGameDto.toDomainFreeGames(): FreeGames {
    return FreeGames(gameUrl, id, shortDescription, thumbnail, title)
}