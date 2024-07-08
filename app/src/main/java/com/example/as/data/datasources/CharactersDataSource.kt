package com.example.`as`.data.datasources

import com.example.`as`.data.network.CharactersApi
import com.example.`as`.data.network.responses.ListResponse
import javax.inject.Inject

class CharactersDataSource @Inject constructor(private val api: CharactersApi) {
    suspend fun fetchCharacters(): ListResponse {
        return api.fetchCharacters()
    }
}