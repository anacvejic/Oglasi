package com.example.zadatak_praksa_android.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.zadatak_praksa_android.data.network.Resource
import com.example.zadatak_praksa_android.databinding.FragmentPozicijaBinding
import com.example.zadatak_praksa_android.entities.Pozicija
import com.example.zadatak_praksa_android.epoxy.PozicijaEpoxyController
import com.example.zadatak_praksa_android.ui.viewmodel.PozicijaViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class PozicijaFragment : Fragment() {

    private val viewModel by viewModels<PozicijaViewModel>()
    val controller = PozicijaEpoxyController(::onPozicijaSelected)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        val binding = FragmentPozicijaBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.epoxyRecyclerViewPozicije.setController(controller)

        viewModel.pozicije.onEach { poz ->
            when (poz) {
                is Resource.Failure -> {
                    Toast.makeText(context, poz.exception.message!!, Toast.LENGTH_LONG).show()
                }

                is Resource.Success -> {
                    controller.setData(poz.result)
                }

                else -> {}
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        return root
    }

    private fun onPozicijaSelected(pozicija: Pozicija) {
        val acttion =
            PozicijaFragmentDirections.actionPozicijaFragmentToDetaljiPozicijeFragment(
                pozicija,
                "Send detalji"
            )
        findNavController().navigate(acttion)
    }
}