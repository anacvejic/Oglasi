package com.example.zadatak_praksa_android.di

import com.example.zadatak_praksa_android.data.PozicijaRepositoryImpl
import com.example.zadatak_praksa_android.data.PozicijaRepository
import com.example.zadatak_praksa_android.data.network.OglasHttpClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.HttpClient

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    fun getHttpClient(httpClient: OglasHttpClient):HttpClient =httpClient.getHttpClient()
    @Provides
    fun getPozicijaRepository(impl: PozicijaRepositoryImpl): PozicijaRepository = impl
}