package com.example.zadatak_praksa_android.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import coil.load
import com.example.zadatak_praksa_android.databinding.FragmentDetaljiPozicijeBinding
import com.example.zadatak_praksa_android.ui.viewmodel.DetaljiPozicijeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetaljiPozicijeFragment : Fragment() {

    private val viewModel: DetaljiPozicijeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentDetaljiPozicijeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.apply {
            img.load("${viewModel.pozImage}")
            tvNaziv.text = viewModel.pozName
            tvPlataRang.text = "Rang plate: ${viewModel.pozRangesalary}"
            if(viewModel.pozTechnology.isNullOrEmpty())
                tvTehnologije.isVisible = false else tvTehnologije.text = "Tehnologije: ${viewModel.pozTechnology}"
            webvJob.loadData(viewModel.pozJob, "text/html", "UTF-8" )
            webvAboutCompany.loadData(viewModel.pozAboutcompany, "text/html", "UTF-8")

        }
        return root
    }
}