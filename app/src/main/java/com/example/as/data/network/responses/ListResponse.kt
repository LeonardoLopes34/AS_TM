package com.example.`as`.data.network.responses

import com.google.gson.annotations.SerializedName

data class ListResponse(
    @SerializedName("results")
    val charactersResult: List<CharactersResponse>
)
