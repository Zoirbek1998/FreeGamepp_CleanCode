package uz.telecom.freegamepp.domain.model

import com.google.gson.annotations.SerializedName

data class FreeGames(
    val gameUrl: String? = null,
    val id: Int? = null,
    val shortDescription: String? = null,
    val thumbnail: String? = null,
    val title: String? = null
)