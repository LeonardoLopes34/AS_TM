package com.example.`as`.data.network

import com.example.`as`.data.network.responses.ListResponse
import retrofit2.http.GET

interface CharactersApi {
    @GET("character")
    suspend fun fetchCharacters(): ListResponse
}