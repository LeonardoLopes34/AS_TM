package com.example.`as`.data.repositories

import com.example.`as`.data.models.Character
import com.example.`as`.data.datasources.CharactersDataSource
import com.example.`as`.data.network.responses.toModel
import javax.inject.Inject

class CharactersRepository @Inject constructor(private val charactersDataSource: CharactersDataSource) {
    suspend fun fetchCharacters(): List<Character> {
        return charactersDataSource.fetchCharacters().charactersResult.map { item -> item.toModel() }
    }
}