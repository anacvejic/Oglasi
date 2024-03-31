package com.example.zadatak_praksa_android.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.zadatak_praksa_android.data.PozicijaRepository
import com.example.zadatak_praksa_android.data.network.Resource
import com.example.zadatak_praksa_android.entities.Pozicija
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PozicijaViewModel @Inject constructor(
    private val repository: PozicijaRepository
) : ViewModel() {
    private val _pozicije = MutableStateFlow<Resource<List<Pozicija>>?>(null)
    val pozicije: StateFlow<Resource<List<Pozicija>>?> = _pozicije

    init {
        viewModelScope.launch {
            _pozicije.value = repository.getPozicija()
        }
    }
}