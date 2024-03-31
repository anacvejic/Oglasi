package com.example.zadatak_praksa_android.ui.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.zadatak_praksa_android.entities.Pozicija
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetaljiPozicijeViewModel @Inject constructor(
    private val state: SavedStateHandle
): ViewModel() {
    val pozicija = state.get<Pozicija>("pozicija")


    var pozAboutcompany = state.get<String>("aboutcompany") ?: pozicija?.aboutcompany ?: ""
        set(value) {
            field = value
            state["aboutcompany"] = value
        }
    var pozImage = state.get<String>("image") ?: pozicija?.image ?: ""
        set(value) {
            field = value
            state["image"] = value
        }
    var pozJob = state.get<String>("job") ?: pozicija?.job ?: ""
        set(value) {
            field = value
            state["job"] = value
        }
    var pozName = state.get<String>("name") ?: pozicija?.name ?: ""
        set(value) {
            field = value
            state["name"] = value
        }
    var pozRangesalary = state.get<String>("rangesalary") ?: pozicija?.rangesalary ?: ""
        set(value) {
            field = value
            state["rangesalary"] = value
        }
    var pozTechnology = state.get<String>("technology") ?: pozicija?.technology ?: ""
        set(value) {
            field = value
            state["technology"] = value
        }
}