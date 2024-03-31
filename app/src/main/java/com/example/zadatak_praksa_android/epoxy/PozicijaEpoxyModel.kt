package com.example.zadatak_praksa_android.epoxy

import coil.load
import com.example.zadatak_praksa_android.R
import com.example.zadatak_praksa_android.databinding.EpoxyModelItemsPozicijeBinding
import com.example.zadatak_praksa_android.entities.Pozicija

data class PozicijaEpoxyModel(
    val pozicija: Pozicija,
    val onPozicijaSelected: (Pozicija) -> Unit
) : ViewBindingKotlinModel<EpoxyModelItemsPozicijeBinding>(R.layout.epoxy_model_items_pozicije) {
    override fun EpoxyModelItemsPozicijeBinding.bind() {
        tvName.text = pozicija.name
        tvRangeOfSalary.text = pozicija.rangesalary
        img.load("${pozicija.image}")

        root.setOnClickListener {
            onPozicijaSelected(pozicija)
        }
    }

}
