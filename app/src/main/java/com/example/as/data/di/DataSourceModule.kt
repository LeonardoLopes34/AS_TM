package com.example.`as`.data.di

import com.example.`as`.data.datasources.CharactersDataSource
import com.example.`as`.data.network.CharactersApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Provides
    @Singleton
    fun providesDataSourceModule(api: CharactersApi): CharactersDataSource {
        return CharactersDataSource(api)
    }
}