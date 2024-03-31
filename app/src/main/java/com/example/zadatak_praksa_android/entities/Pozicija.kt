package com.example.zadatak_praksa_android.entities


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class Pozicija(
    @SerialName("aboutcompany")
    val aboutcompany: String,
    @SerialName("id")
    val id: Int,
    @SerialName("image")
    val image: String,
    @SerialName("job")
    val job: String,
    @SerialName("name")
    val name: String,
    @SerialName("rangesalary")
    val rangesalary: String,
    @SerialName("technology")
    val technology: String
): Parcelable