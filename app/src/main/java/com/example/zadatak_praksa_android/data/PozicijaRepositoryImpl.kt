package com.example.zadatak_praksa_android.data

import com.example.zadatak_praksa_android.entities.Pozicija
import com.example.zadatak_praksa_android.entities.PozicijaModel
import com.example.zadatak_praksa_android.data.network.BASE_URL
import com.example.zadatak_praksa_android.data.network.Resource
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.url
import javax.inject.Inject

private const val urlPozicija = "$BASE_URL"

class PozicijaRepositoryImpl @Inject constructor(
private val httpClient: HttpClient
) : PozicijaRepository {
    override suspend fun getPozicija(): Resource<List<Pozicija>> {
        return try {
            Resource.Success(
                httpClient.get<PozicijaModel> {
                    url(urlPozicija)
                }.pozicija
            )
        }catch (e: Exception){
            e.printStackTrace()
            Resource.Failure(e)
        }
    }
}