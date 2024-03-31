package com.example.zadatak_praksa_android.entities


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PozicijaModel(
    @SerialName("pozicija")
    val pozicija: List<Pozicija>
)