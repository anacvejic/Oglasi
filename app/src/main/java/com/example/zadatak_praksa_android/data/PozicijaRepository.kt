package com.example.zadatak_praksa_android.data

import com.example.zadatak_praksa_android.data.network.Resource
import com.example.zadatak_praksa_android.entities.Pozicija

interface PozicijaRepository {
    suspend fun getPozicija(): Resource<List<Pozicija>>
}