package com.example.zadatak_praksa_android.epoxy

import com.airbnb.epoxy.TypedEpoxyController
import com.example.zadatak_praksa_android.entities.Pozicija

class PozicijaEpoxyController(private val onPozicijaSelected: (Pozicija) -> Unit) :
    TypedEpoxyController<List<Pozicija>>() {
    override fun buildModels(data: List<Pozicija>?) {
        if (data == null || data.isEmpty()) {
            return
        }

        data.forEach { poz ->
            PozicijaEpoxyModel(poz, onPozicijaSelected = onPozicijaSelected).id(poz.id).addTo(this)
        }
    }
}