package com.example.`as`.data.di

import com.example.`as`.data.datasources.CharactersDataSource
import com.example.`as`.data.repositories.CharactersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun providesCharactersRepository(charactersDataSource: CharactersDataSource): CharactersRepository {
        return CharactersRepository(charactersDataSource)
    }
}